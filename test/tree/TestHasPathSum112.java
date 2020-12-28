package tree;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2020/12/28
 */
public class TestHasPathSum112 extends TestCase {

    private HasPathSum112 hasPath = new HasPathSum112();

    public void test1() {
        TreeNode root = new TreeNode(-2);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(-3);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(11);
        node1.left = node3;
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node3.left = node4;
        node3.right = node5;

        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        node2.left = node6;
        node2.right = node7;

        node7.right = new TreeNode(1);

        boolean flag = hasPath.hasPathSum(root, 14);
        Assert.assertTrue(flag);
    }

    public void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        boolean flag = hasPath.hasPathSum(root, 1);
        Assert.assertFalse(flag);
    }

    public void test3() {
        boolean flag = hasPath.hasPathSum(null, 0);
        Assert.assertFalse(flag);
    }
}
