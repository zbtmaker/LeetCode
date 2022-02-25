package backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019\3\3 0003.
 */
public class PermuteUnique47 {

    /**
     * 这个题目其实是permute46的一个变种题，方法一可以从permute46中在最后的结果输出中添加一个
     * 去重操作，如果要去重，那么我们就不得不使用HashMap
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums.length == 0) {
            return lists;
        }
        recurPermuteUnique(nums, 0, lists);

        return lists;
    }

    private void recurPermuteUnique(int[] nums, int index, List<List<Integer>> lists) {
        if (index == nums.length - 1) {
            lists.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            /*System.out.println(Arrays.toString(nums));*/
            return;
        }
        Set<Integer> set = new HashSet<>();
        set.add(nums[index]);
        recurPermuteUnique(nums, index + 1, lists);

        for (int i = index + 1; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                swap(nums, index, i);
                recurPermuteUnique(nums, index + 1, lists);
                swap(nums, index, i);
            }

        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
