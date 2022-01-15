package array;

/**
 * Created by Administrator on 2019\1\24 0024.
 * (一)题目：给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积
 * (二)思路：此题其实和combinationSum那个题很相似，就是给定一个数n,我们需要做的就是构造一个长为n-1的candidate数组，
 * 数组中的元素为1~n-1,
 */
public class IntegerBreak343 {

    public int integerBreak(int n) {
        return breakByDP(n);
    }

    /**
     * 其实我们知道每个n都可以被拆分为两个正整数n1和n2，其中n1+n2 = n, 那么对应的最大
     * 乘积max(n) = max(n1) * max(n2)，比方说当n = 10，此时可以分解为(1, 9)、(2, 8)
     * (3, 7)、(4, 6)、(5,5)。当n = 9,此时可以分解为(1,8)、(2,7)、(3,6)、(4,5)。
     * 然后我们知道这里其实是一个二叉树，其中每一个二叉树中其中有很多正整数的最大值都在被重复
     * 计算。既然有重复计算，那么就可以用动态规划来解决问题
     *
     * @param n
     * @return
     */
    private int breakByDP(int n) {
        int[] aux = new int[n + 1];
        aux[1] = 1;
        for (int i = 2; i <= n; i++) {
            int half = i >> 1;
            int tmp = 0;
            for (int k = 1; k <= half; k++) {
                tmp = Math.max(tmp, k * (i - k));
                tmp = Math.max(tmp, k * aux[i - k]);
            }
            aux[i] = tmp;
        }
        return aux[n];
    }

    /**
     * 采用暴力的方式解决，首先将n的各种组合全部枚举出来，然后取每个组合的最大值即可。
     *
     * @param n
     * @return
     */
    private int breakByCombinationSum(int n) {
        int[] candidates = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            candidates[i] = i + 1;
        }

        int max = 0, sum = 0, product = 1;
        for (int i = 0; i < candidates.length; i++) {
            sum += candidates[i];
            product *= candidates[i];
            max = recurCombinationSum(candidates, n, sum, i, product, max);
            product = 1;
            sum = 0;
        }
        return max;
    }

    private int recurCombinationSum(int[] candidates, int target,
                                    int sum, int index, int product, int max) {
        if (sum == target) {
            return Math.max(max, product);
        }

        if (sum > target) {
            return max;
        }

        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            product *= candidates[i];
            max = recurCombinationSum(candidates, target, sum, i, product, max);
            product /= candidates[i];
            sum -= candidates[i];
        }
        return max;
    }
}
