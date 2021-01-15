package array;

/**
 * @author Baitao Zou
 * date 2021/01/16
 */
public class Find132pattern456 {
    /**
     * 如果我们采用暴力的方式，对于0 ≤ i ≤ nums.length - 1，对于任意的 1 ≤ j ≤ nums.length -2,我们都需要比较nums[j]左边
     * 和右边的值，我们第一步优化以下，对于0 < j这一部分，我们只要记录一个最小值leftMin，如果这个leftMin < nums[j]，那么表明
     * 左边满足条件。同样的我们需要在右边找一个元素，这个元素是满足nums[j] > nums[right]，但是这个nums[right]一定是右边满足条件
     * 且是最大的。time complexity O(N^2), space complexity O(1)，待优化。
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        int leftMin = nums[0];
        for (int j = 1; j < len - 1; j++) {
            leftMin = Math.min(leftMin, nums[j]);
            if (leftMin == nums[j]) {
                continue;
            }
            for (int k = j + 1; k < len; k++) {
                if (leftMin < nums[k] && nums[k] < nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
