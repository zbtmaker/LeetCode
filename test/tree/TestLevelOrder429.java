package tree;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Baitao Zou
 * date 2020/12/27
 */
public class TestLevelOrder429 extends TestCase {

    private LevelOrder429 levelOrder = new LevelOrder429();


    public void test1() {
        Node root = new Node(1, null);
        Node node1 = new Node(3, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(4, null);
        Node node4 = new Node(5, null);
        Node node5 = new Node(6, null);

        List<Node> l0 = new ArrayList<>();
        l0.add(node1);
        l0.add(node2);
        l0.add(node3);
        root.children = l0;

        List<Node> l1 = new ArrayList<>();
        l1.add(node4);
        l1.add(node5);
        node1.children = l1;

        List<List<Integer>> lists = new LevelOrder429().levelOrder(root);
        print(lists);
    }

    private void print(List<List<Integer>> result) {
        if (result == null || result.size() == 0) {
            return;
        }
        for (List<Integer> cur : result) {
            System.out.println(cur.toString());
        }
    }
}
