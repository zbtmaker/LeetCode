package design;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考文章：
 * https://15721.courses.cs.cmu.edu/spring2018/papers/08-oltpindexes1/pugh-skiplists-cacm1990.pdf
 * https://www.youtube.com/watch?v=2g9OSRKJuzM&ab_channel=MITOpenCourseWare
 *
 * @author zoubaitao
 * date 2022/03/27
 */
public class SkipLists1206 {

    private static final double p = 0.5;

    private static final int MAX_LEVEL = 16;

    private final SkipListsNode head;

    private static class SkipListsNode {
        /**
         * 分值
         */
        private final int score;

        /**
         * 前进指针
         */
        private final List<SkipListsNode> forwards;

        /**
         * 当前节点跨越的层次
         */
        private int level;

        /**
         * 这里记录一相同的元素出现的次数，这里在插入相同的元素时没有重新插入节点，
         * 而是采用一个频率来实现这个方案，如果我们要存储相同的score或者是member
         * 那么我们就需要是一个List来存储相同score对应的member。
         */
        private int freq;

        public SkipListsNode(int score, int level, int freq) {
            this.score = score;
            this.level = level;
            this.freq = freq;
            this.forwards = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                this.forwards.add(null);
            }
        }
    }

    public SkipLists1206() {
        head = new SkipListsNode(Integer.MIN_VALUE, 1, 1);
    }

    /**
     * 如果target在skip lists中，则返回true，否则返回false。
     *
     * @param target 待搜寻数字
     * @return true-target在skip lists中 ｜ false-target不在skip lists
     */
    public boolean search(int target) {
        SkipListsNode x = head;
        int level = x.level;
        for (int i = level - 1; i > -1; i--) {
            while (x.forwards.get(i) != null && x.forwards.get(i).score < target) {
                x = x.forwards.get(i);
            }
        }
        x = x.forwards.get(0);
        return x != null && x.score == target;
    }

    /**
     * 如果num 在skip lists中，则直接返回，如果不存在，则添加到skip lists中
     *
     * @param num 数字
     */
    public void add(int num) {
        SkipListsNode[] update = new SkipListsNode[MAX_LEVEL];
        SkipListsNode x = find(num, update);
        if (x != null && x.score == num) {
            x.freq = x.freq + 1;
            return;
        }
        int level = randomLevel();
        int maxLevel = head.level;

        if (level > maxLevel) {
            for (int i = maxLevel; i < level; i++) {
                update[i] = head;
                head.forwards.add(null);
            }
            head.level = level;
        }
        x = new SkipListsNode(num, level, 1);
        for (int i = 0; i < level; i++) {
            SkipListsNode parent = update[i];
            x.forwards.set(i, parent.forwards.get(i));
            parent.forwards.set(i, x);
        }
    }

    /**
     * 如果num不在skip lists则返回false，如果num 在skip lists则返回true，且删除
     *
     * @param num 待删除数字
     * @return true-num 在skip lists，删除后返回 ｜ false-num不在skip lists中
     */
    public boolean erase(int num) {
        SkipListsNode[] update = new SkipListsNode[MAX_LEVEL];
        SkipListsNode x = find(num, update);
        if (x == null || x.score != num) {
            return false;
        }
        x.freq = x.freq - 1;
        if (x.freq > 0) {
            return true;
        }
        for (int i = 0; i < head.level; i++) {
            if (update[i].forwards.get(i) != x) {
                break;
            }
            update[i].forwards.set(i, x.forwards.get(i));
            x.forwards.set(i, null);
        }
        while (head.level > 1 && head.forwards.get(head.level - 1) == null) {
            head.level = head.level - 1;
        }
        return true;
    }

    private SkipListsNode find(int target, SkipListsNode[] update) {
        SkipListsNode x = head;
        int maxLevel = x.level;
        for (int i = maxLevel - 1; i > -1; i--) {
            while (x.forwards.get(i) != null && x.forwards.get(i).score < target) {
                x = x.forwards.get(i);
            }
            update[i] = x;
        }
        return x.forwards.get(0);
    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < p && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }
}
