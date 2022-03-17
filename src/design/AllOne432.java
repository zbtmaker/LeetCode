package design;

import java.util.*;

/**
 * @author zoubaitao
 * date 2022/03/16
 */
public class AllOne432 {

    private static final String EMPTY_STRING = "";

    /**
     * 用于判断key是否存在
     */
    private final Map<String, Node> nodeMap;

    /**
     * 存储频率节点，其实这个题目有点像LRU Cache，不同的是这里只需要Set就能解决问题
     */
    private final Map<Integer, Set<Node>> freqMap;
    /**
     * 头节点
     */
    private final Node head;

    /**
     * 尾节点
     */
    private final Node tail;

    public AllOne432() {
        freqMap = new HashMap<>();
        nodeMap = new HashMap<>();
        head = new Node(EMPTY_STRING, Integer.MAX_VALUE);
        tail = new Node(EMPTY_STRING, Integer.MIN_VALUE);
        head.next = tail;
        tail.last = head;
    }

    public void inc(String key) {
        Node cur = nodeMap.get(key);
        if (cur == null) {
            cur = new Node(key, 1);
            nodeMap.put(key, cur);
            Set<Node> set = freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>());
            set.add(cur);
            if (head.next == tail) {
                head.next = cur;
                cur.last = head;
            } else {
                tail.last.next = cur;
                cur.last = tail.last;
            }
            tail.last = cur;
            cur.next = tail;
        } else {
            int freq = cur.freq;
            Set<Node> lastEqualFreqSet = freqMap.get(freq);
            lastEqualFreqSet.remove(cur);
            Set<Node> newEqualFreqSet = freqMap.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>());
            cur.freq = cur.freq + 1;
            newEqualFreqSet.add(cur);

            Node last = cur.last;
            while (last != head && last.freq < cur.freq) {
                last = last.last;
            }
            // 更新node前一个节点和后一个节点之间的关系
            cur.last.next = cur.next;
            cur.next.last = cur.last;

            // 更新last后一个节点的前一个节点关系
            last.next.last = cur;
            cur.next = last.next;

            // 更新last和node之前的关系
            cur.last = last;
            last.next = cur;
        }

    }

    public void dec(String key) {
        Node cur = nodeMap.get(key);
        int freq = cur.freq;
        Set<Node> freqSet = freqMap.get(freq);
        freqSet.remove(cur);
        if (freqSet.isEmpty()) {
            freqMap.remove(freq);
        }
        if (freq - 1 == 0) {
            nodeMap.remove(key);
            cur.last.next = cur.next;
            cur.next.last = cur.last;
            return;
        }
        freqSet = freqMap.computeIfAbsent(freq - 1, k -> new LinkedHashSet<>());
        cur.freq = freq - 1;
        freqSet.add(cur);

        Node next = cur.next;
        while (next != tail && next.freq > cur.freq) {
            next = next.next;
        }

        // 断开cur的关系
        cur.last.next = cur.next;
        cur.next.last = cur.last;

        // 重建cur关系
        cur.next = next;
        cur.last = next.last;

        // 断开next关系
        next.last.next = cur;
        next.last = cur;
    }

    public String getMaxKey() {
        return getKey(freqMap.get(head.next.freq));
    }

    private String getKey(Set<Node> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return EMPTY_STRING;
        }

        Iterator<Node> iterator = nodes.iterator();
        return iterator.next().key;
    }

    public String getMinKey() {
        return getKey(freqMap.get(tail.last.freq));
    }

    private static class Node {
        private final String key;

        private int freq;

        public Node(String key, int freq) {
            this.key = key;
            this.freq = freq;
        }

        /**
         * 存储当前节点的前一个节点
         */
        public Node last;

        /**
         * 存储当前节点的下一个节点
         */
        private Node next;
    }
}
