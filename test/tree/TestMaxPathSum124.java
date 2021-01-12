package tree;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/01/12
 */
public class TestMaxPathSum124 extends TestCase {

    private MaxPathSum124 path = new MaxPathSum124();

    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int max = path.maxPathSum(root);
        Assert.assertEquals(max, 6);
    }

    public void test2() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);

        TreeNode node1 = new TreeNode(20);
        root.right = node1;
        node1.left = new TreeNode(15);
        node1.right = new TreeNode(7);

        int max = path.maxPathSum(root);
        Assert.assertEquals(max, 42);
    }

    public void test3() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(-9);

        root.right = new TreeNode(-20);

        int max = path.maxPathSum(root);
        Assert.assertEquals(max, -9);
    }

    public void test4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-9);

        root.right = new TreeNode(-20);

        int max = path.maxPathSum(root);
        Assert.assertEquals(max, 1);
    }


    public void test5() {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(11);
        node1.left = node3;
        node3.left = new TreeNode(7);
        node3.right = new TreeNode(2);

        node2.left = new TreeNode(13);
        node2.right = new TreeNode(4);

        int max = path.maxPathSum(root);
        Assert.assertEquals(max, 48);
    }

    public void test6() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int max = path.maxPathSum(root);
        Assert.assertEquals(max, 3);
    }
}
