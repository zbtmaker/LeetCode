package array;

/**
 * Created by Administrator on 2019\2\27 0027.
 */
public class FindPeakElement162 {
    /**
     * 一遍扫描即可
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        return findPeakElementByTraverse(nums);
    }

    /**
     * 一遍扫描的方式解决该问题
     *
     * @param nums
     * @return
     */
    public int findPeakElementByTraverse(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
                return i;
            } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    public int findPeakElementByBinarySearch(int[] nums) {
        return 0;
    }
}
