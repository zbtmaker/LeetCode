package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zoubaitao
 * date 2022/03/26
 */
public class FindPairs532 {

    /**
     * 使用DFS思想，每个i节点都会被遍历两边，因此时间复杂度为O(N), 空间复杂度
     * 为O(N)
     *
     * @param nums 数组
     * @param k    数字绝对值之差
     * @return 数组中元素之差的绝对值等于k的对数
     */
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> numMapCount = new HashMap<>();
        for (int num : nums) {
            numMapCount.put(num, numMapCount.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        if (k == 0) {
            return (int) numMapCount.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() > 1)
                    .count();
        }
        Set<Integer> numSet = numMapCount.keySet();
        Set<Integer> addSet = new HashSet<>();
        for (Integer num : numSet) {
            count += dfs(numSet, addSet, num, k);
        }
        return count;
    }

    private int dfs(Set<Integer> numSet, Set<Integer> addSet, int num, int k) {
        if (addSet.contains(num) || !numSet.contains(num)) {
            return 0;
        }
        addSet.add(num);
        int count = 0;
        if (numSet.contains(num - k) && !addSet.contains(num - k)) {
            count += dfs(numSet, addSet, num - k, k) + 1;
        }

        if (numSet.contains(num + k) && !addSet.contains(num + k)) {
            count += dfs(numSet, addSet, num + k, k) + 1;
        }
        return count;
    }
}
