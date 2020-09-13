package backtracking;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/09/13
 */
public class FindSubsequences491 {
    /**
     * 这个题目我们第一步就是考虑数组中不存在相同元素的问题该如何递归，
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                list.add(nums[i]);
                recur(i, nums, list, result, set);
                list.removeLast();
            }

        }
        return result;
    }

    private void recur(int i, int[] nums, LinkedList<Integer> list, List<List<Integer>> result, Set<String> set) {
        if (list.size() > 1) {
            String str = list.toString();
            if (!set.contains(str)) {
                List<Integer> tmpList = new LinkedList<>(list);
                result.add(tmpList);
                set.add(str);
            }

        }

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] <= nums[j] && (j == i + 1 || nums[j] != nums[j - 1])) {
                list.add(nums[j]);
                recur(j, nums, list, result, set);
                list.removeLast();
            }
        }
    }
}
