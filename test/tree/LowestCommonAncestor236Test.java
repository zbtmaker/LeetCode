package tree;

import junit.framework.TestCase;

public class LowestCommonAncestor236Test extends TestCase {

    public void test1() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(4);
        node4.left = node5;
        node4.right = node6;

        TreeNode node7 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        node2.left = node7;
        node2.right = node8;

        TreeNode c = new LowestCommonAncestor236().lowestCommonAncestor(root, node6, node1);
        System.out.println(c.val);
    }

    public void test2() {
        TreeNode root = new TreeNode(-1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(-2);
        TreeNode node4 = new TreeNode(-4);
        node1.left = node3;
        node1.right = node4;


        TreeNode node6 = new TreeNode(8);
        node3.left = node6;


        TreeNode c = new LowestCommonAncestor236().lowestCommonAncestor(root, node6, node2);
        System.out.println(c.val);
    }
}
