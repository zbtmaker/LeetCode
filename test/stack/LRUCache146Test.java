package stack;

import com.oracle.webservices.internal.api.message.BasePropertySet;
import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/01/27
 */
public class LRUCache146Test {


    @Test
    public void test1() {
        LRUCache146 cache = new LRUCache146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(cache.get(1), 1);
        cache.put(3, 3);
        Assert.assertEquals(cache.get(2), -1);
        cache.put(4, 4);
        Assert.assertEquals(cache.get(1), -1);
        Assert.assertEquals(cache.get(3), 3);
        Assert.assertEquals(cache.get(4), 4);
    }

    @Test
    public void test2() {
        LRUCache146 cache = new LRUCache146(2);
        Assert.assertEquals(cache.get(2), -1);
        cache.put(2, 6);
        Assert.assertEquals(cache.get(1), -1);
        cache.put(1, 5);
        cache.put(1, 2);
        Assert.assertEquals(cache.get(1), 2);
        Assert.assertEquals(cache.get(2), 6);
    }

    @Test
    public void test3() {
        LRUCache146 cache = new LRUCache146(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        Assert.assertEquals(cache.get(1), -1);
        Assert.assertEquals(cache.get(2), 3);
    }
}
