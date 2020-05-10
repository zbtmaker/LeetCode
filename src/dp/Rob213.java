package dp;

/**
 * @author baitao zou
 * date 2020/05/10
 */
public class Rob213 {
    /**
     * 这个题目就是Rob198的延升，因为这个题目是一个循环数组，也就是第一栋楼和最后一栋楼
     * 那么如果我们偷了第一栋房子那么我们就不能偷最后一栋房子，如果我们偷了最后一栋房子就不能偷第一栋
     * 房子，还有一种情况是如果如果我们既不偷第一栋房子也不偷最后一栋房子，那么就是偷中间一栋房子。
     * 其实之前我也是思考过这种方案，但是我们如何证明这个思路是对的，这个是最重要的。但是我先把这个
     * 问题记录下来。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, nums.length - 1),
                robRange(nums, 1, nums.length));
    }

    private int robRange(int[] nums, int start, int end) {
        int fir = 0;
        int sec = nums[start];
        for (int i = start + 2; i <= end; i++) {
            int max = Math.max(sec, fir + nums[i - 1]);
            fir = sec;
            sec = max;
        }
        return sec;
    }
}
