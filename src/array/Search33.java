package array;

/**
 * Created by Administrator on 2019\1\11 0011.
 */
public class Search33 {

    /**
     * 这个题目的解题思路要求是O(NlogN),那么一定是采用二分法来做。
     * 1、找到旋转的位置，返回相应的索引
     * 2、根据这left，right以及pivot就可以进行二分法
     *
     * @param nums   数组
     * @param target 目标
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return binarySearch(nums, left, right, target);
        }
        int rotate = findRotateIndex(nums,left,right);

        if (target < nums[left] && target > nums[right]) {
            return -1;
        }
        if (target > nums[right]) {
            right = rotate - 1;
        }
        if (target < nums[left]) {
            left = rotate;
        }

        return binarySearch(nums, left, right, target);
    }

    /**
     * 二分法查找算法
     *
     * @param nums   数组
     * @param left   左区间
     * @param right  右区间
     * @param target 查找目标
     * @return
     */
    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 找到最小的元素的位置
     *
     * @param nums
     * @return
     */
    public int findRotateIndex(int[] nums,int left,int right) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if (nums[mid] < nums[left]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}
