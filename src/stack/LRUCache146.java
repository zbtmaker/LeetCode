package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author baitao zou
 * date 2020/01/27
 */
public class LRUCache146 {
    private Map<Integer, Integer> map;
    private TreeMap<Integer, Integer> treeMap;
    private int capacity;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        treeMap = new TreeMap<>();
    }

    /**
     * @param key 查找的Key
     * @return 存在返回value，不存在返回-1
     */
    public int get(int key) {
        Integer value = map.get(key);
        //如果value不为null，那么统计该Key的频率，同时
        return value == null ? -1 : value;
    }

    public void put(int key, int value) {
        if (map.size() < capacity) {
            map.put(key, value);
            treeMap.put(1,key);
        } else {
        }

    }
}
