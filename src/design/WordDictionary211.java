package design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baitao zou
 * date 2020/10/03
 */
public class WordDictionary211 {
    /**
     * trie前缀树 根节点
     */
    private final Node root;

    private static final char DOT = '.';
    private static final char EMPTY = ' ';

    private static class Node {
        /**
         * children node
         */
        private Map<Character, Node> children;

        /**
         * the value of the node
         */
        private final char val;

        /**
         * 标志这个位置是否是一个单词的结尾处
         */
        private boolean flag;

        Node(char val) {
            this.val = val;
            flag = false;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public WordDictionary211() {
        root = new Node(' ');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        insert(word, 0, root);
    }

    /**
     * add a word into the data in recursive way
     *
     * @param word  带插入元素
     * @param index 索引
     * @param root  当前节点根节点
     */
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
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, Node root) {
        if (index == word.length()) {
            return root.flag || root.children == null;
        }
        if (root.children == null) {
            return false;
        }
        Map<Character, Node> children = root.children;
        char ch = word.charAt(index);
        if (ch == DOT) {
            for (Map.Entry<Character, Node> entry : children.entrySet()) {
                if (search(word, index + 1, entry.getValue())) {
                    return true;
                }
            }
        } else {
            Node cur = children.get(ch);
            if (cur == null) {
                return false;
            } else {
                return search(word, ++index, cur);
            }
        }
        return false;
    }
}
