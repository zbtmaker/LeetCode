package design;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/05/05
 */
public class RandomizedCollection381 {
    /**
     * 这里我使用了一个Set俩保存重复数字在List当中的位置这是这里唯一和RandomizedSet唯一不同的
     * 地方。
     */
    private final Map<Integer, Set<Integer>> map;
    /**
     * 数组保存数据
     */
    private final List<Integer> list;
    private final Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection381() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean flag = false;
        Set<Integer> indexSet = map.get(val);
        if (indexSet == null) {
            flag = true;
            indexSet = new HashSet<>();
        }
        list.add(val);
        indexSet.add(list.size() - 1);
        map.put(val, indexSet);
        return flag;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     * 这个地方很重要
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int lastElement = list.get(list.size() - 1);
        Set<Integer> lastSet = map.get(lastElement);
        Set<Integer> curSet = map.get(val);
        int curIndex = -1;
        for (int index : curSet) {
            curIndex = index;
            curSet.remove(curIndex);
            break;
        }
        list.set(curIndex, lastElement);

        if (curSet.size() == 0) {
            map.remove(val);
        }
        //将lastElment的最后一个节点删除，然后更新当前节点
        lastSet.remove(list.size() - 1);
        lastSet.add(curIndex);

        //从列表中删除最后一个元素
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
