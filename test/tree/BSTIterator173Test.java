package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/26
 */
public class BSTIterator173Test {


    private BSTIterator173 iterator;

    @Test
    public void test1() {
        TreeCommonUtils.TreeNode root = new TreeCommonUtils.TreeNode(7);
        TreeCommonUtils.TreeNode node1 = new TreeCommonUtils.TreeNode(3);
        TreeCommonUtils.TreeNode node2 = new TreeCommonUtils.TreeNode(15);
        TreeCommonUtils.TreeNode node3 = new TreeCommonUtils.TreeNode(9);
        TreeCommonUtils.TreeNode node4 = new TreeCommonUtils.TreeNode(20);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        iterator = new BSTIterator173(root);
        Assert.assertEquals(iterator.next(), 3);
        Assert.assertEquals(iterator.next(), 7);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(iterator.next(), 9);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(iterator.next(), 15);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(iterator.next(), 20);
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void test2() {
        TreeCommonUtils.TreeNode root = new TreeCommonUtils.TreeNode(7);
        iterator = new BSTIterator173(root);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(iterator.next(), 7);
    }

    @Test
    public void test3() {
        iterator = new BSTIterator173(null);
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void test4() {
        TreeCommonUtils.TreeNode root = new TreeCommonUtils.TreeNode(4);
        TreeCommonUtils.TreeNode node1 = new TreeCommonUtils.TreeNode(3);
        TreeCommonUtils.TreeNode node2 = new TreeCommonUtils.TreeNode(2);
        TreeCommonUtils.TreeNode node3 = new TreeCommonUtils.TreeNode(1);

        root.left = node1;
        node1.left = node2;
        node2.left = node3;

        iterator = new BSTIterator173(root);
        Assert.assertEquals(iterator.next(),1);
        Assert.assertEquals(iterator.next(),2);
        Assert.assertEquals(iterator.next(),3);
        Assert.assertEquals(iterator.next(),4);
    }
}
