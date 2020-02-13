package array;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author baitao zou
 * date 2020/02/12
 */
public class MajorityElement229 {
    /**
     * 这个题目和MajorityElement229一致，都有三种解法，其中HashMap肯定有比HashMap更优的方法
     * 1、HashMap统计法，time complexity O(N), space complexity O(N).
     * 2、更优的方法。
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        return majorityElementByHashMap(nums);
    }

    /**
     * 使用HashMap统计方式实现，算法time complexity O(N),space complexity O(N)
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElementByHashMap(int[] nums) {
        List<Integer> result = new LinkedList<>();
        Map<Integer, Integer> map = ArrayUtils.count(nums);
        int triple = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > triple) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    /**
     * 这个题目因为需要记录超过1/3数组长度的元素，那么如果一个数组中有超过1/3的元素。那么这个数组中最多只有
     * 两个元素超过了这个数组。这个题目和SingleNumber136和SingleNumber260一样。一开始是只有一哥元素出现一次
     * 后面有两个元素只出现一次。这个题目是有可能有两个元素超过了这个数组中的1/3。
     * 解题思路：
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElementByOtherAlgorithm(int[] nums) {
        List<Integer> result = new LinkedList<>();

        return result;
    }
}
