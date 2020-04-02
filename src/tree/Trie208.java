package tree;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/04/01
 */
public class Trie208 {
    private Node root;
    private Set<String> set;
    private static final char EMPTY = ' ';

    /**
     * 内部类用于记录当前节点的字符以及其子节点的字符
     */
    private static class Node {
        private Character val;
        private List<Node> child;

        public Node() {

        }

        Node(Character val) {
            this(val, null);
        }

        Node(Character val, List<Node> child) {
            this.val = val;
            this.child = child;
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
        Node parent = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            List<Node> child = parent.child;
            if (child == null) {
                child = new LinkedList<>();
                parent.child = child;
                Node node = new Node(ch);
                child.add(node);
                parent = node;
            } else {
                boolean flag = false;
                for (Node node : child) {
                    if (node.val.equals(ch)) {
                        parent = node;
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    Node node = new Node(ch);
                    child.add(node);
                    parent = node;
                }
            }
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
        List<Node> child = root.child;
        while (i < prefix.length() && child != null) {
            boolean flag = false;
            for (Node node : child) {
                if (node.val.equals(prefix.charAt(i))) {
                    flag = true;
                    child = node.child;
                }
            }
            if (!flag) {
                return false;
            }
            i++;
        }
        return i == prefix.length();
    }
}
