package array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\17 0017.
 */
public class LargestPerimeter976 {

    /**
     * 这里首先使用排序的方式，时间复杂度为O(nlogn), 空间复杂度为O(1)
     * 从后往前寻找连续的三个数，因为nums[n] > nums[n-1] > nums[n-2]，如果nums[n]、nums[n-1]、nums[n-2]不能构成一个三角形
     * 也就意味着nums[n] > nums[n-1] + nums[n-2]，那么对于边nums[n]这条边就不会与nums数组中任何一条边能够构成一个三角形。
     * 这也就是这个题目采用排序+贪心的方式解决问题了
     * ，那么
     *
     * @param nums 边集合
     * @return 周长最大的三角形
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; --i) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}
