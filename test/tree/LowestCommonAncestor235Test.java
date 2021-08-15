package tree;

import junit.framework.TestCase;

public class LowestCommonAncestor235Test extends TestCase {
    public void test() {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;


        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(5);
        node4.left = node5;
        node4.right = node6;

        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(9);
        node2.left = node7;
        node2.right = node8;

        LowestCommonAncestor235 lowest = new LowestCommonAncestor235();
        TreeNode common = lowest.lowestCommonAncestor(root, node3, node6);
        System.out.println(common.val);
    }
}
