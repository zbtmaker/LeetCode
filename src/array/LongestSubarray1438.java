package array;

import java.util.TreeMap;

/**
 * @author Baitao Zou
 * date 2021/02/23
 */
public class LongestSubarray1438 {

    public int longestSubarray(int[] nums, int limit) {
        int l = 0, r = 0, longest = 0;
        TreeMap<Integer, Integer> minMaxMap = new TreeMap<>();
        for (; r < nums.length; r++) {
            minMaxMap.put(nums[r], minMaxMap.getOrDefault(nums[r], 0) + 1);
            if (Math.abs(minMaxMap.firstKey() - minMaxMap.lastKey()) > limit) {
                longest = Math.max(longest, r - l);
            }
            while (Math.abs(minMaxMap.firstKey() - minMaxMap.lastKey()) > limit && l < r) {
                int count = minMaxMap.get(nums[l]);
                count--;
                if (count == 0) {
                    minMaxMap.remove(nums[l]);
                } else {
                    minMaxMap.put(nums[l], count);
                }
                l++;
            }
        }
        return Math.max(longest, r - l);
    }
}
