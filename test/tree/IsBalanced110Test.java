package tree;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/04/30
 */
public class IsBalanced110Test extends TestCase {

    private IsBalanced110 balanced = new IsBalanced110();

    public void test1() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node2.left = node3;
        node2.right = node4;

        node3.left = new TreeNode(6);

        Assert.assertFalse(balanced.isBalanced(root));
    }

    public void test2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode node1 = new TreeNode(20);
        root.right = node1;

        node1.left = new TreeNode(15);
        node1.right = new TreeNode(7);

        Assert.assertTrue(balanced.isBalanced(root));
    }
}
