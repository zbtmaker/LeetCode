package dp;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/05/05
 */
public class CanCross403 {
    public boolean canCross(int[] stones) {
        return canCrossByMemorization(stones);
    }

    /**
     * 采用回溯算法解决问题，但是time complexity O(2^N), space complexity O(1).采用空间复杂度问题
     * 时间超时了，这个代码还需要优化一下
     *
     * @param stones
     * @return
     */
    private boolean canCrossByBacktracking(int[] stones) {
        return recurCanCross(stones, 0, 0);
    }

    private boolean recurCanCross(int[] stones, int index, int step) {
        if (index == stones.length - 1) {
            return true;
        }
        for (int i = index + 1; i < stones.length; i++) {
            if (stones[i] > stones[index] + step + 1) {
                break;
            }
            if (stones[i] == stones[index] + step - 1) {
                if (recurCanCross(stones, i, step - 1)) {
                    return true;
                }
            } else if (stones[i] == stones[index] + step) {
                if (recurCanCross(stones, i, step)) {
                    return true;
                }
            } else if (stones[i] == stones[index] + step + 1) {
                if (recurCanCross(stones, i, step + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 对回溯算法采用记忆之后，时间复杂度变高了O(N^3)，空间复杂度变成了O(N)，还是需要好好优化一下算法的复杂度。
     *
     * @param stones 石头位置
     * @return true-可以到达 ｜ false-不能到达
     */
    private boolean canCrossByMemorization(int[] stones) {
        int len = stones.length;
        boolean[] dp = new boolean[len];
        List<Set<Integer>> stepList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        stepList.add(set);
        for (int i = 1; i < len; i++) {
            Set<Integer> curStep = new HashSet<>();
            boolean flag = false;
            for (int j = i - 1; j >= 0; j--) {
                Set<Integer> steps = stepList.get(j);
                for (int step : steps) {
                    if (stones[i] == stones[j] + step - 1) {
                        curStep.add(step - 1);
                        flag = true;
                    } else if (stones[i] == stones[j] + step) {
                        curStep.add(step);
                        flag = true;
                    } else if (stones[i] == stones[j] + step + 1) {
                        curStep.add(step + 1);
                        flag = true;
                    }
                }
            }
            stepList.add(curStep);
            dp[i] = flag;
        }
        return dp[len - 1];
    }
}
