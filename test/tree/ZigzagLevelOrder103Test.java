package tree;

import org.junit.Test;

import java.util.List;

public class ZigzagLevelOrder103Test {
    private ZigzagLevelOrder103 zigzagLevelOrder103 = new ZigzagLevelOrder103();

    @Test
    public void test1() {
        ZigzagLevelOrder103.TreeNode node1 = new ZigzagLevelOrder103.TreeNode(3);
        ZigzagLevelOrder103.TreeNode node2 = new ZigzagLevelOrder103.TreeNode(9);
        ZigzagLevelOrder103.TreeNode node3 = new ZigzagLevelOrder103.TreeNode(20);
        ZigzagLevelOrder103.TreeNode node4 = new ZigzagLevelOrder103.TreeNode(15);
        ZigzagLevelOrder103.TreeNode node5 = new ZigzagLevelOrder103.TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        List<List<Integer>> list = zigzagLevelOrder103.zigzagLevelOrder(node1);
        for (List<Integer> tmpList : list) {
            System.out.println(tmpList);
        }
    }


    @Test
    public void test2() {
        ZigzagLevelOrder103.TreeNode node1 = new ZigzagLevelOrder103.TreeNode(3);
        List<List<Integer>> list = zigzagLevelOrder103.zigzagLevelOrder(node1);
        for (List<Integer> tmpList : list) {
            System.out.println(tmpList);
        }
    }

    @Test
    public void test3() {
        List<List<Integer>> list = zigzagLevelOrder103.zigzagLevelOrder(null);
        for (List<Integer> tmpList : list) {
            System.out.println(tmpList);
        }
    }

    @Test
    public void test4() {
        ZigzagLevelOrder103.TreeNode node1 = new ZigzagLevelOrder103.TreeNode(3);
        ZigzagLevelOrder103.TreeNode node2 = new ZigzagLevelOrder103.TreeNode(9);
        ZigzagLevelOrder103.TreeNode node3 = new ZigzagLevelOrder103.TreeNode(20);
        ZigzagLevelOrder103.TreeNode node4 = new ZigzagLevelOrder103.TreeNode(15);
        ZigzagLevelOrder103.TreeNode node5 = new ZigzagLevelOrder103.TreeNode(7);

        ZigzagLevelOrder103.TreeNode node6 = new ZigzagLevelOrder103.TreeNode(18);
        ZigzagLevelOrder103.TreeNode node7 = new ZigzagLevelOrder103.TreeNode(19);

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

    @Test
    public void test5() {
        ZigzagLevelOrder103.TreeNode node1 = new ZigzagLevelOrder103.TreeNode(3);
        ZigzagLevelOrder103.TreeNode node2 = new ZigzagLevelOrder103.TreeNode(9);
        ZigzagLevelOrder103.TreeNode node3 = new ZigzagLevelOrder103.TreeNode(20);
        ZigzagLevelOrder103.TreeNode node4 = new ZigzagLevelOrder103.TreeNode(15);
        ZigzagLevelOrder103.TreeNode node5 = new ZigzagLevelOrder103.TreeNode(7);

        ZigzagLevelOrder103.TreeNode node6 = new ZigzagLevelOrder103.TreeNode(18);
        ZigzagLevelOrder103.TreeNode node7 = new ZigzagLevelOrder103.TreeNode(19);

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
