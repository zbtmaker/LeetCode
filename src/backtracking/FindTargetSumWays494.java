package backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Baitao Zou
 * date 2021/01/01
 */
public class FindTargetSumWays494 {

    /**
     * @param nums   数组
     * @param target 目标和
     * @return 返回满足目标和的方式
     */
    public int findTargetSumWays(int[] nums, int target) {
        return byRecurMemorization(nums, target);
    }

    /**
     * 采用递归方式，每一个数字有两种选择，一种是前面添加'+'，另一种就是'-'，
     * 我们用一个sum来统计累加的数。整个递归过程就是一个二叉树遍历，如果数组
     * nums中有n个数字，那么时间复杂度为O(2^n)，空间复杂度为O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    private int byRecur(int[] nums, int target) {
        return recur(nums, 0, 0, target);
    }

    /**
     * 递归方式
     *
     * @param nums   数组
     * @param index  索引
     * @param sum    当前位置目标和
     * @param target 目标和
     */
    private int recur(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        int left = recur(nums, index + 1, sum + nums[index], target);
        int right = recur(nums, index + 1, sum - nums[index], target);
        return left + right;
    }

    /**
     * 根据上面的递归方式，我们其实可以发现其中有很多递归操作，
     * 那么如果将计算结果存储起来，那么是不是就能解决我们在递归过程
     * 中重复计算某一个二叉树的问题
     * 我们用pairs[i-1] 表示第i个子树的所有结果，那么递推关系就有
     * pairs[i] = {pairs[i-1] + nums[i],pairs[i-1] - nums[i]}
     * 这种计算方式的结果就是时间超时。
     *
     * @param nums
     * @param target
     * @return
     */
    private int byLoopAndMemorization(int[] nums, int target) {
        List<Integer> last = new LinkedList<>();
        last.add(0);
        for (int j : nums) {
            List<Integer> cur = new LinkedList<>();
            for (Integer num : last) {
                cur.add(num + j);
                cur.add(num - j);
            }
            last = cur;
        }
        return (int) last.stream().filter(num -> num == target).count();
    }

    private int byRecurMemorization(int[] nums, int target) {
        return recurByMemorization(nums, 0, 0, target, new HashMap<>());
    }

    private int recurByMemorization(int[] nums, int index, int sum, int target, Map<String, Integer> cache) {
        String key = index + ":" + sum;

        if (cache.get(key) != null) {
            return cache.get(key);
        }

        if (index == nums.length) {
            int result = sum == target ? 1 : 0;
            cache.put(key, result);
            return result;
        }


        int left = recurByMemorization(nums, index + 1, sum + nums[index], target, cache);
        int right = recurByMemorization(nums, index + 1, sum - nums[index], target, cache);
        cache.put(key, left + right);
        return left + right;
    }


}
