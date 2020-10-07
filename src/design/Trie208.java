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
    private static final char EMPTY = ' ';

    /**
     * 内部类用于记录当前节点的字符以及其子节点的字符
     */
    public static class Node {
        private char val;
        private boolean flag;
        private Map<Character, Node> children;

        Node(char val) {
            this.val = val;
            flag = false;
        }
    }

    Trie208() {
        root = new Node(EMPTY);
    }

    /**
     * 前缀数的添加操作，其实就是和二叉树的添加元素差不多
     * 这种前缀树有点多叉树的感觉
     *
     * @param word 字符
     */
    public void insert(String word) {
        insert(word, 0, root);
    }

    private void insert(String word, int index, Node root) {
        if (index == word.length()) {
            root.flag = true;
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
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Map<Character, Node> children = cur.children;
            if (children == null) {
                return false;
            }
            char ch = word.charAt(i);
            Node node = children.get(ch);
            if (node == null) {
                return false;
            }
            cur = node;
        }
        return cur.flag;
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
