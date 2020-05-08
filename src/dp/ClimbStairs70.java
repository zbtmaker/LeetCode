package dp;

/**
 * @author baitao zou
 * date 2020/05/08
 */
public class ClimbStairs70 {
    /**
     * 动态规划解决这个爬楼梯问题，分析这类问题自顶向下分析问题。对于这类动态规划问题，其实最初解决的问题就是
     * 使用回溯算法。然后发现会有重复计算问题，那么我们就可以采用一个一维数组来保存之前计算结果。
     * step1：定义辅助数组aux[i]表示长度为i的阶梯，爬阶梯的种数。
     * step2：因为每次只能走1步或者2步，那么给定一个长度为i时，那么我们就可以知道i - 1的走法，以及i - 2时的走法
     * 那么我们直接加起来就好了。其实我们可以通过
     * step3：当i = 0，aux[i] = 0表示长度为0时，能够的走法为0，但是我们在考虑当i = 2时aux[i] = aux[i-1] + aux[i-1],
     * 所以我们将aux[0] = 1;当长度为1时表示长度为1的阶梯有1种爬行方式
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        return climbStairsByDPByOneDimension(n);
    }

    /**
     * 采用一维数组解决动态规划问题
     *
     * @param n
     * @return
     */
    private int climbStairsByDPByOneDimension(int n) {
        int[] aux = new int[n + 1];
        aux[0] = 1;
        aux[1] = 1;
        for (int i = 2; i < aux.length; i++) {
            aux[i] = aux[i - 1] + aux[i - 2];
        }
        return aux[n];
    }

    /**
     * 采用常数时间复杂度解决动态规划问题
     *
     * @param n
     * @return
     */
    private int climbStairsByDPConstant(int n) {
        int fir = 1;
        int sec = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = fir + sec;
            fir = sec;
            sec = tmp;
        }
        return sec;
    }
}
