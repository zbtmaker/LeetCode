package array;

/**
 * Created by Administrator on 2019\2\27 0027.
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 *
 * @author Baitao Zou
 * date 2020/12/01
 */
public class SearchRange34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int i = 0;
        while (i < nums.length && nums[i] != target) {
            i++;
        }
        if (i == nums.length) {
            return result;
        }
        result[0] = i;
        while (i < nums.length && nums[i] == target) {
            i++;
        }
        result[1] = i - 1;
        return result;
    }
}
