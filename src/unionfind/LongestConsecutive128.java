package unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author baitao zou
 * date 2020/03/04
 */
public class LongestConsecutive128 {

    public int longestConsecutive(int[] nums) {
        return longestConsecutiveWithoutCountReduplicate(nums);
    }

    /**
     * 最长连续序列，不统计重复元素出现的个数
     *
     * @param nums 数字
     * @return 最长连续序列的长度
     */
    private int longestConsecutiveWithoutCountReduplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int longest = 0;
        Map<Integer, Integer> parent = new HashMap<>(len);

        for (int num : nums) {
            if (parent.containsKey(num)) {
                continue;
            }
            if (parent.containsKey(num - 1)) {
                parent.put(num - 1, num);
            }
            if (parent.containsKey(num + 1)) {
                parent.put(num, num + 1);
            } else {
                parent.put(num, null);
            }
        }

        Map<Integer, Integer> count = new HashMap<>(len);
        for (int num : nums) {
            if (count.containsKey(num)) {
                continue;
            }
            int curLen = calculateLen(num, parent, count);
            longest = Math.max(curLen, longest);
        }
        return longest;
    }

    /**
     * 递归求解父节点的长度
     *
     * @param num
     * @param parent
     * @param count
     * @return
     */
    private int calculateLen(Integer num, Map<Integer, Integer> parent, Map<Integer, Integer> count) {
        if (num == null) {
            return 0;
        }
        if (count.containsKey(num)) {
            return count.get(num);
        }
        int len = calculateLen(parent.get(num), parent, count);
        len++;
        count.put(num, len);
        return len;
    }

    /**
     * In this method, we use union find to solve this problem,
     * but different from the general union find algorithm.We use
     * the HashMap to replace the parent array to record the parent
     * of a number.
     *
     * @param nums a array which has
     * @return the longest consecutive of the array.
     */
    private int longestConsecutiveCountReduplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int longest = 0;
        Map<Integer, Integer> parent = new HashMap<>(len);

        Map<Integer, Integer> count = new HashMap<>(len);
        for (int num : nums) {
            if (parent.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                if (parent.containsKey(num - 1)) {
                    parent.put(num - 1, num);
                }
                if (parent.containsKey(num + 1)) {
                    parent.put(num, num + 1);
                } else {
                    parent.put(num, null);
                }
                count.put(num, 1);
            }

        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            int curLen = calculateLen(num, parent, count, set);
            longest = Math.max(curLen, longest);
        }
        return longest;
    }

    /**
     * A method to calculate the parent num's count and
     * the current num count. We use a recursive method
     * to implements the method.
     *
     * @param num    current num
     * @param parent the parent collection of each num
     * @param count  each count of num repeat count.
     * @param set    the hashSet to record the num has visit or not
     * @return
     */
    private int calculateLen(Integer num, Map<Integer, Integer> parent, Map<Integer, Integer> count, Set<Integer> set) {
        if (num == null) {
            return 0;
        }
        if (set.contains(num)) {
            return count.get(num);
        }
        int len = calculateLen(parent.get(num), parent, count, set);
        len += count.get(num);
        count.put(num, len);
        set.add(num);
        return len;
    }
}
