package dp;

/**
 * 我们有两个长度相等且不为空的整型数组 A 和 B 。
 * 我们可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。
 * 在交换过一些元素之后，数组 A 和 B 都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。
 * 给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。
 * 链接：https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing
 *
 * @author baitao zou
 * date 2020/04/16
 */
public class MinSwap801 {

    /**
     * 1、这个问题使用动态规划的思想来解决，从问题观察来看，如果我们要
     * 找到数组长度len的最小交换次数，我们看这个问题采用自顶向下的
     * 分析方式，我们知道我们要计算长度为len的数组，那么长度为len-1
     * 的数组一定已经是排好序的数组了，那么我们长度问len的数组的最小交换
     * 次数就是看len-1的长度的数组的交换次数以及最后一对值A[len]和B[len]
     * 与A[len-1]和B[len-1]之间的关系了。
     * 2、根据上面的分析，我们用一个一维辅助数组dp[]来表示最小交换次数，其中
     * 对于任意的i,有dp[i]表示长度为i+1的数组最小交换数。
     * 3、综合上面的分析和定义，对于数组A、B我们可以得到一个递推关系对于任意的
     * i == 0, dp[i] = 0
     * 0< i <= A.length, dp[i] = dp[i] + (A[i] < A[i-1] || B[i] < B[i-1] ? 1 : 0)
     * 4、还有另外一个问题就是交换哪个元素才合理。
     *
     * @param A 数组A
     * @param B 数组B
     * @return 最小交换次数
     */
    public int minSwap(int[] A, int[] B) {
        if (A == null || B == null || A.length <= 1) {
            return 0;
        }
        int len = A.length, count = 0;
        for (int i = 1, j = 1; i < len; i++, j++) {
            if (A[i] <= A[i - 1] || B[i] <= B[i - 1]) {
                if (A[i] <= A[i - 1] && B[i] > A[i - 1]) {

                }
                count++;
            }
        }
        return count;
    }

    private void swap(int[] A, int[] B, int i) {
        A[i] = A[i] ^ B[i];
        B[i] = A[i] ^ B[i];
        A[i] = A[i] ^ B[i];
    }
}
