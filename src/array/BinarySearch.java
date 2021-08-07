package array;

/**
 * @author Baitao Zou
 * date 2021/01/10
 */
public class BinarySearch {

    /**
     * 从无序、无重复元素数组
     *
     * @param nums   有序，无重复元素数组
     * @param target 目标
     * @return 索引，不存在则返回 -1
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 在有序，有重复数组中寻找目标值在数组中最左边的索引
     *
     * @param nums   二维数组
     * @param target 目标
     * @return 最左索引
     */
    public int leftIndexSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * 在有序，有重复数组中寻找目标值在数组中最右边的索引
     *
     * @param nums   二维数组
     * @param target 目标
     * @return 最右索引
     */
    public int rightIndexSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1) + 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[right] == target ? right : -1;
    }
}
