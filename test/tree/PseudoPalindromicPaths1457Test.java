package tree;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/05/25
 */
public class PseudoPalindromicPaths1457Test extends TestCase {
    private PseudoPalindromicPaths1457 palindromicPaths = new PseudoPalindromicPaths1457();

    public void test1() {
        TreeNode node1 = new TreeNode(1);
        int path = palindromicPaths.pseudoPalindromicPaths(node1);
        Assert.assertEquals(path, 1);
    }

    public void test2() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(1);
        node3.right = node6;

        int path = palindromicPaths.pseudoPalindromicPaths(node1);
        Assert.assertEquals(path, 2);
    }

    public void test3() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(1);
        node5.right = node6;

        int path = palindromicPaths.pseudoPalindromicPaths(node1);
        Assert.assertEquals(path, 1);
    }
}
