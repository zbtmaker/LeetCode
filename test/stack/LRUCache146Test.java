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
    private LRUCache146 cache = new LRUCache146(2);

    @Test
    public void testLinkedHashMap() {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for(Map.Entry<Integer, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    @Test
    public void test1() {
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(cache.get(1), 1);
        cache.put(3, 3);
        Assert.assertEquals(cache.get(2), 2);
        cache.put(4, 4);
        Assert.assertEquals(cache.get(1), -1);
        Assert.assertEquals(cache.get(3), 3);
        Assert.assertEquals(cache.get(4), 4);
    }
}
