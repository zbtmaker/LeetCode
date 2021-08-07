package array;

/**
 * Created by Administrator on 2019\3\4 0004.
 */
public class FindMin153 {


    /**
     * 本题是Search33的一部分，Search33再这个题目基础上增加了一些操作。
     * 我们要找到旋转数组的最小的元素，题目中要求的time complexity O(logN),
     * space complexity O(1).从题目的要求可以知道要求使用binary search
     * algorithm来实现。那么既然大的方向有了，我们就是需要确定判断条件和循环退出的
     * 条件。
     * 1、循环退出的条件，也就是找到了最小值，nums[i]>nums[i+1],如果这个数组旋转了，那么
     * 肯定会i+1肯定是那个最小值。
     * 2、如果数组没有旋转，那么肯定要返回0,接下来的分析都是讨论数组旋转了情况。
     * 3、如果nums[mid]>nums[left],切nums[mid] < nums[mid+]1.那么这个时候表示递增的序列。
     * 如果是递增的序列，那么此时应该是left = mid+1,如果nums[mid] < nums[left]且nums[mid] < nums[mid+1]
     * 此时
     * [4,5,6,7,8,9,0,1,2]
     * 第一次mid = 8,此时nums[mid] < nums[mid+1],nums[left] < nums[mid],因此left = mid+1;
     * [7,0,1,2,3,4,5,6,7]
     * 第一次mid = 3,此时nums[mid] < nums[mid+1],nums[left] > nums[right],因此right= mid-1;
     * *
     *
     * @param nums 目标数组
     * @return 最小值
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 1 || nums[left] < nums[right]) {
            return nums[left];
        }
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] < nums[0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
