package design;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/06/28
 */
public class MyCircularDeque641Test extends TestCase {

    public void test1() {
        MyCircularDeque641 circularDeque = new MyCircularDeque641(3);
        Assert.assertTrue(circularDeque.insertLast(1));                    // 返回 true
        Assert.assertTrue(circularDeque.insertLast(2));                    // 返回 true
        Assert.assertTrue(circularDeque.insertFront(3));                    // 返回 true
        Assert.assertFalse(circularDeque.insertFront(4));                    // 已经满了，返回 false
        Assert.assertEquals(circularDeque.getRear(), 2);                // 返回 2
        Assert.assertTrue(circularDeque.isFull());                        // 返回 true
        Assert.assertTrue(circularDeque.deleteLast());                    // 返回 true
        Assert.assertTrue(circularDeque.insertFront(4));                    // 返回 true
        Assert.assertEquals(circularDeque.getFront(), 4);                // 返回 4
    }

    public void test2() {
        MyCircularDeque641 circularDeque = new MyCircularDeque641(8);
        Assert.assertTrue(circularDeque.insertFront(5));
        Assert.assertEquals(circularDeque.getFront(), 5);
        Assert.assertFalse(circularDeque.isEmpty());
        Assert.assertTrue(circularDeque.deleteFront());
        Assert.assertTrue(circularDeque.insertLast(3));
        Assert.assertEquals(circularDeque.getRear(), 3);
        Assert.assertTrue(circularDeque.insertLast(7));
        Assert.assertTrue(circularDeque.insertFront(7));
        Assert.assertTrue(circularDeque.deleteLast());
        Assert.assertTrue(circularDeque.insertLast(4));
        Assert.assertFalse(circularDeque.isEmpty());
    }
}
