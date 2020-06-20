package tree;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/06/19
 */
public class DiameterOfBinaryTree543Test extends TestCase {
    private DiameterOfBinaryTree543 diameter = new DiameterOfBinaryTree543();

    public void test1() {
        DiameterOfBinaryTree543.TreeNode root = new DiameterOfBinaryTree543.TreeNode(1);
        DiameterOfBinaryTree543.TreeNode node1 = new DiameterOfBinaryTree543.TreeNode(2);
        DiameterOfBinaryTree543.TreeNode node2 = new DiameterOfBinaryTree543.TreeNode(3);
        root.left = node1;
        root.right = node2;

        DiameterOfBinaryTree543.TreeNode node3 = new DiameterOfBinaryTree543.TreeNode(4);
        DiameterOfBinaryTree543.TreeNode node4 = new DiameterOfBinaryTree543.TreeNode(5);
        node1.left = node3;
        node1.right = node4;
        int max = diameter.diameterOfBinaryTree(root);
        Assert.assertEquals(max, 3);
    }

    public void test2() {
        DiameterOfBinaryTree543.TreeNode root = new DiameterOfBinaryTree543.TreeNode(1);

        int max = diameter.diameterOfBinaryTree(root);
        Assert.assertEquals(max, 0);
    }


    public void test3() {
        DiameterOfBinaryTree543.TreeNode root = new DiameterOfBinaryTree543.TreeNode(1);
        DiameterOfBinaryTree543.TreeNode node1 = new DiameterOfBinaryTree543.TreeNode(2);
        DiameterOfBinaryTree543.TreeNode node2 = new DiameterOfBinaryTree543.TreeNode(3);
        root.left = node1;
        root.right = node2;

        int max = diameter.diameterOfBinaryTree(root);
        Assert.assertEquals(max, 2);
    }

    public void test4() {
        int max = diameter.diameterOfBinaryTree(null);
        Assert.assertEquals(max, 0);
    }
}
