package array;

/**
 * @author zoubaitao
 * date 2022/04/10
 */
public class NumSubarrayProductLessThanK713 {

    /**
     * 这个题目就是在数组nums中找到一个子数组，其中子数组的中搜有元素的乘积小于k。
     * 那么我们用滑动窗口来解决这个问题，两个指针left、right分别指向满足条件的子数组。
     * 如果在[left, right]数组中不能满足条件，那么left肯定会大于right。需要考虑的问题有
     * 下面几个：
     * 1、一个窗口[left, right]长度为win = right - left + 1，满足的条件为数组个数 win(1 + win) / 2。
     * 2、如果两个数组之间存在交叠的区域，那么需要减去这个交叠的区域产生的子数组，因为满足两个交叠的区域会被重复计算
     * 所以我们就需要记录上一个窗口的右边界。
     *
     * @param nums 数组
     * @param k    窗口乘积上限
     * @return 满足条件的子数组个数
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0, lastRight = -1;
        int len = nums.length;
        int mul = 1, res = 0;
        boolean flag = true;
        while (right < len) {
            mul *= nums[right];
            while (mul >= k && right >= left) {
                if (flag && right > left) {
                    res += calc(left, right, lastRight);
                    flag = false;
                    lastRight = right - 1;
                }
                mul /= nums[left];
                left++;
            }
            flag = true;
            right++;
        }
        if (mul < k) {
            res += calc(left, right, lastRight);
        }
        return res;
    }

    private int calc(int left, int right, int lastRight) {
        int res = 0;
        int win = right - 1 - left + 1;
        res += win * (1 + win) / 2;
        if (left <= lastRight) {
            int crossWin = lastRight - left + 1;
            res -= crossWin * (1 + crossWin) / 2;
        }
        return res;
    }
}
