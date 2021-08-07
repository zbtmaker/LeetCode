package tree;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * @author Baitao zou
 * date 2021/01/04
 */
public class ZigzagLevelOrder103Test extends TestCase {
    private ZigzagLevelOrder103 zigzagLevelOrder103 = new ZigzagLevelOrder103();

    public void test1() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        List<List<Integer>> list = zigzagLevelOrder103.zigzagLevelOrder(node1);
        for (List<Integer> tmpList : list) {
            System.out.println(tmpList);
        }
    }

    public void test2() {
        TreeNode node1 = new TreeNode(3);
        List<List<Integer>> list = zigzagLevelOrder103.zigzagLevelOrder(node1);
        for (List<Integer> tmpList : list) {
            System.out.println(tmpList);
        }
    }

    public void test3() {
        List<List<Integer>> list = zigzagLevelOrder103.zigzagLevelOrder(null);
        for (List<Integer> tmpList : list) {
            System.out.println(tmpList);
        }
    }

    public void test4() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        TreeNode node6 = new TreeNode(18);
        TreeNode node7 = new TreeNode(19);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        node5.left = node6;
        node5.right = node7;
        List<List<Integer>> list = zigzagLevelOrder103.zigzagLevelOrder(node1);
        for (List<Integer> tmpList : list) {
            System.out.println(tmpList);
        }
    }

    public void test5() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        TreeNode node6 = new TreeNode(18);
        TreeNode node7 = new TreeNode(19);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        node2.left = node6;
        node2.right = node7;
        List<List<Integer>> list = zigzagLevelOrder103.zigzagLevelOrder(node1);
        for (List<Integer> tmpList : list) {
            System.out.println(tmpList);
        }
    }
}
