package array;

/**
 * @author Baitao Zou
 * date 2021/02/25
 */
public class Search81 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) {

        }

        int minIndex = findMin(nums);
        if (nums[minIndex] == target) {
            return true;
        }
        return nums[minIndex] > target ? search(nums, 0, minIndex - 1, target) : search(nums, minIndex + 1, nums.length - 1, target);
    }

    private boolean search(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }
        return l;
    }
}
