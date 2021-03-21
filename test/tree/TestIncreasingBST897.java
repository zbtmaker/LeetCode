package tree;

import junit.framework.TestCase;

/**
 * @author Baitao Zou
 * date 2021/03/21
 */
public class TestIncreasingBST897 extends TestCase {
    public void test1() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node4;
        node1.right = node5;

        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        node2.left = node6;
        node2.right = node7;

        node7.right = new TreeNode(5);

        new IncreasingBST897().increasingBST(root);
    }
}
