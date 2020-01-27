package stack;

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
    public void test1() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1,3);
        map.put(2,1);
        map.put(3,2);
        NavigableMap navigableMap = map.descendingMap();
        Set<Map.Entry<Integer,Integer>> entrySet = navigableMap.entrySet();
        entrySet.forEach(System.out::println);
    }
}
