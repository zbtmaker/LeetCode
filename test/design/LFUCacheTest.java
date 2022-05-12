package design;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/05/12
 */
public class LFUCacheTest extends TestCase {

    public void test1() {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        Assert.assertEquals(lfu.get(1), 1);
        lfu.put(3, 3);
        Assert.assertEquals(lfu.get(2), -1);
        Assert.assertEquals(lfu.get(3), 3);
        lfu.put(4, 4);
        Assert.assertEquals(lfu.get(1), -1);
        Assert.assertEquals(lfu.get(4), 4);
    }

    public void test2() {
        LFUCache lfu = new LFUCache(2);
        lfu.put(3, 1);
        lfu.put(2, 1);
        lfu.put(2, 2);
        lfu.put(4, 4);
        Assert.assertEquals(lfu.get(2), 2);
    }

    public void test3() {
        LFUCache lfu = new LFUCache(0);
        lfu.put(0, 0);
        lfu.get(0);
    }

    public void test4() {
        LFUCache lfu = new LFUCache(3);
        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.put(3, 3);
        lfu.put(4, 4);
        Assert.assertEquals(lfu.get(4), 4);
        Assert.assertEquals(lfu.get(3), 3);
        Assert.assertEquals(lfu.get(2), 2);
        Assert.assertEquals(lfu.get(1), -1);

        lfu.put(5, 5);
        Assert.assertEquals(lfu.get(1), -1);
        Assert.assertEquals(lfu.get(2), 2);
        Assert.assertEquals(lfu.get(3), 3);
        Assert.assertEquals(lfu.get(4), -1);
        Assert.assertEquals(lfu.get(5), 5);
    }

    public void test5() {
        LFUCache lfu = new LFUCache(10);
        lfu.put(7, 28);
        lfu.put(7, 1);
        lfu.put(8, 15);
        Assert.assertEquals(lfu.get(6), -1);
        lfu.put(10, 27);
        lfu.put(8, 10);
        Assert.assertEquals(lfu.get(8), 10);
        lfu.put(6, 29);
        lfu.put(1, 9);
        Assert.assertEquals(lfu.get(6), 29);
        lfu.put(10, 7);
        Assert.assertEquals(lfu.get(1), 9);
        Assert.assertEquals(lfu.get(2), -1);
        Assert.assertEquals(lfu.get(13), -1);
        lfu.put(8, 30);
        lfu.put(1, 5);
        Assert.assertEquals(lfu.get(1), 5);
        lfu.put(13, 2);
        Assert.assertEquals(lfu.get(12), -1);
    }


    public void test6() {
        LFUCache lfu = new LFUCache(10);
        lfu.put(10, 13);
        lfu.put(3, 17);
        lfu.put(6, 11);
        lfu.put(10, 5);
        lfu.put(9, 10);
        Assert.assertEquals(lfu.get(13), -1);
        lfu.put(2, 19);
        Assert.assertEquals(lfu.get(2), 19);
        Assert.assertEquals(lfu.get(3), 17);
        lfu.put(5, 25);
        Assert.assertEquals(lfu.get(8), -1);
        lfu.put(9, 22);
        lfu.put(5, 5);
        lfu.put(1, 30);
        Assert.assertEquals(lfu.get(11), -1);
        lfu.put(9, 12);
        Assert.assertEquals(lfu.get(7), -1);
        Assert.assertEquals(lfu.get(5), 5);
        Assert.assertEquals(lfu.get(8), -1);
        Assert.assertEquals(lfu.get(9), 12);
        lfu.put(4, 30);
        lfu.put(9, 3);
        Assert.assertEquals(lfu.get(9), 3);
        Assert.assertEquals(lfu.get(10), 5);
        Assert.assertEquals(lfu.get(10), 5);
        lfu.put(6, 14);
        lfu.put(3, 1);
        Assert.assertEquals(lfu.get(3), 1);
        lfu.put(10, 11);
        Assert.assertEquals(lfu.get(8), -1);
        Assert.assertEquals(lfu.get(2), 19);
        Assert.assertEquals(lfu.get(1), 30);
        Assert.assertEquals(lfu.get(5), 5);
        Assert.assertEquals(lfu.get(4), 30);
        lfu.put(11, 4);
        lfu.put(12, 24);
        lfu.put(5, 18);
        Assert.assertEquals(lfu.get(13), -1);
        lfu.put(7, 23);
        Assert.assertEquals(lfu.get(8), -1);
        Assert.assertEquals(lfu.get(12), 24);
        lfu.put(3,27);
        lfu.put(2,12);
        Assert.assertEquals(lfu.get(1), 30);
        Assert.assertEquals(lfu.get(5), 18);
    }
}
