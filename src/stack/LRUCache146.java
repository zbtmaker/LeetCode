package stack;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/01/27
 */
public class LRUCache146 {
    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    /**
     * @param key 查找的Key
     * @return 存在返回value，不存在返回-1
     */
    public int get(int key) {
        Integer val = map.get(key);
        if (val == null) {
            return -1;
        }
        map.remove(key);
        map.put(key, val);
        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        map.put(key, value);
        if (map.size() > capacity) {
            Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
            int i = 0;
            Integer tmpKey = null;
            for (Map.Entry<Integer, Integer> entry : entrySet) {
                if (i == 0) {
                    tmpKey = entry.getKey();
                    break;
                }
                i++;
            }
            map.remove(tmpKey);
        }
    }
}
