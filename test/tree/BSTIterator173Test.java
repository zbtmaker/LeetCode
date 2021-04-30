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
        TreeNode root = new TreeNode(7);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(20);
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
        TreeNode root = new TreeNode(7);
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
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);

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
