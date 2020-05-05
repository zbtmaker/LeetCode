package design;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/05/05
 */
public class RandomizedSet380 {
    /**
     * 这里的Map用来存储val是否存在于List当中，以及每个val在List中
     * 对应的位置，就可以将要删除的数组放到数组最后，并更新最后一个元素
     * 的索引为要删除元素所在的位置。很厉害的一个思想，采用索引记录和交换
     * 元素，删除最后一个元素，使得空间复制最大程度减少。
     */
    private final Map<Integer, Integer> map;
    /**
     * 这里为什么会考虑随机接入，只有动态数组有这个特性，所以采用
     * ArrayList是最合适的方案
     */
    private final List<Integer> list;
    private final Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet380() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int lastElement = list.get(list.size() - 1);
        int curIndex = map.get(val);
        list.set(curIndex, lastElement);
        map.put(lastElement, curIndex);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
