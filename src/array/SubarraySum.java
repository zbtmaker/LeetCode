package array;

/**
 * Created by Administrator on 2019\1\21 0021.
 */
public class SubarraySum {

    /**
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        return subarraySumByAuxiliaryArray(nums, k);
    }

    /**
     * 通过最粗暴的方式来解决这个问题,时间复杂度为O（N^3）,空间复杂度为O（1）。下面就需要分析一下，我们能不能用
     * O（N）的空间来换算一下时间。
     *
     * @param nums
     * @param k
     * @return
     */
    private int subarraySumByBruteForce(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                int sum = 0;
                for (int m = j; m <= i; m++) {
                    sum += nums[m];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 上面这个操作我们可以看到对于最里面的循环我们可以去掉，就是用一个数组来记下来，而不是
     * 每次都选择去计算。对于一个长度为3的数组，for循环里面相当于做了这件事
     * 第一次循环、sum = nums[0] + nums[1] + nums[2] = aux
     * 第二次循环、sum = nums[1] + nums[2] = aux[2] - aux[0]
     * 第三次循环、sum = nums[2] = aux[2] - aux[1]
     * 那么我们是不是可以用一个辅助数组aux来存储之前计算的和，其中aux[i]表示数组中前i位元素之和。
     * 既然有了这个辅助数组，那我们就可以动手写代码了。通过这种方式们已经优化了一层for循环了，将
     * 时间复杂度由O（N^3）-->变成了O（N^2)时间复杂度，空间复杂度变为O（N）。
     *
     * @return
     */
    private int subarraySumByAuxiliaryArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int len = nums.length;
        int[] aux = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            aux[i] = aux[i - 1] + nums[i - 1];
            for (int j = 0; j < i; j++) {
                int sum = aux[i] - aux[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
