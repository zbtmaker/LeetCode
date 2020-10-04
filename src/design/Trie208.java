package design;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/04/01
 */
public class Trie208 {
    /**
     * 前缀树的根节点
     */
    private final Node root;
    /**
     * 用来存储放入的字符串
     */
    private final Set<String> set;

    private static final char EMPTY = ' ';

    /**
     * 内部类用于记录当前节点的字符以及其子节点的字符
     */
    private static class Node {
        private char val;
        private Map<Character, Node> children;

        Node(char val) {
            this.val = val;
        }
    }

    Trie208() {
        set = new HashSet<>();
        root = new Node(EMPTY);
    }

    /**
     * 前缀数的添加操作，其实就是和二叉树的添加元素差不多
     * 这种前缀树有点多叉树的感觉
     *
     * @param word 字符
     */
    public void insert(String word) {
        set.add(word);
        insert(word, 0, root);
    }

    private void insert(String word, int index, Node root) {
        if (index == word.length()) {
            return;
        }
        char ch = word.charAt(index);
        Node cur = new Node(ch);
        Map<Character, Node> children = root.children;
        if (children == null) {
            children = new HashMap<>();
            root.children = children;
            children.put(ch, cur);
            insert(word, ++index, cur);
        } else {
            Node node = children.get(ch);
            if (node == null) {
                children.put(ch, cur);
                node = cur;
            }
            insert(word, ++index, node);
        }
    }

    /**
     * 字符是否存在Tire中
     *
     * @param word 字符
     * @return true-存在 ｜ false-不存在
     */
    public boolean search(String word) {
        return set.contains(word);
    }

    /**
     * 以某个字符开头的字符串是否存在Tire树中
     *
     * @param prefix 字符前缀
     * @return true-存在 ｜ false-不存在
     */
    public boolean startWith(String prefix) {
        int i = 0;
        Map<Character, Node> children = root.children;
        while (i < prefix.length() && children != null) {
            char ch = prefix.charAt(i);
            if (!children.containsKey(ch)) {
                return false;

            }
            children = children.get(ch).children;
            i++;
        }
        return i == prefix.length();
    }
}
