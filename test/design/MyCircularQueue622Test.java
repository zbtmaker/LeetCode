package design;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/06/28
 */
public class MyCircularQueue622Test extends TestCase {


    public void test1() {
        MyCircularQueue622 circularQueue = new MyCircularQueue622(3);
        Assert.assertTrue(circularQueue.enQueue(1));
        Assert.assertTrue(circularQueue.enQueue(2));
        Assert.assertTrue(circularQueue.enQueue(3));
        Assert.assertFalse(circularQueue.enQueue(4));
        Assert.assertEquals(circularQueue.Rear(), 3);
        Assert.assertTrue(circularQueue.isFull());
        Assert.assertTrue(circularQueue.deQueue());
        Assert.assertTrue(circularQueue.enQueue(4));
        Assert.assertEquals(circularQueue.Rear(), 4);
    }
}
