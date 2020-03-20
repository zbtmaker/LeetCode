package math;

/**
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * @author Baitao Zou
 * date 2019\3\30 0030.
 */
public class TotalHammingDistance477 {


    private static final int BITCOUNT = 31;

    /**
     * 思路，我们计算所有数字每一位为1的和，对于每一位
     * ，如果有N个1，那么该位的汉明距离位N*(nums.length - N).
     * 这个很好理解，因为如果有N个1，那么其中会有nums.length - N 个
     * 0。因此每一个1都有nums.length个汉明距离。
     *
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int[] total = new int[BITCOUNT];
        for (int num : nums) {
            intToBitArray(num, total);
        }
        int count = 0;
        for (int i = 0; i < BITCOUNT; i++) {
            count += total[i] * (nums.length - total[i]);
        }
        return count;
    }

    /**
     * 计算bit位为1的和
     *
     * @param num   目标数字
     * @param total 比特位数组
     */
    private void intToBitArray(int num, int[] total) {
        int i = 0;
        int count = 1;
        while (i < BITCOUNT) {
            int result = num & count;
            if (result != 0) {
                total[i]++;
            }
            i++;
            count = count << 1;
        }
    }
}
