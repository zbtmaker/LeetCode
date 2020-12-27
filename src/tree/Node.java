package tree;

import java.util.List;

/**
 * @author Baitao Zou
 * date 2020/12/27
 */
public class Node {
    int val;
    List<Node> children;

    public Node() {
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
