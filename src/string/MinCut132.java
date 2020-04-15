package string;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\8 0008.
 */
public class MinCut132 {

    public int minCut(String s) {
        /*return minCutByBacktracking(s);*/
        return minCutByDynamicProgramming(s);
    }

    /**
     * 采用动态规划的方式实现，time complexity(N^2),space complexity O(N^2)
     *
     * @param s
     * @return
     */
    private int minCutByDynamicProgramming(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                /*System.out.println("s.substring(" + i + "," + j + ")" + s.substring(i, j + 1));*/
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 == j) {
                        dp[i][j] = 0;
                    } else if (dp[i + 1][j - 1] == 0) {
                        dp[i][j] = 0;
                    } else {
                        int min = Integer.MAX_VALUE;
                        for (int k = i; k < j; k++) {
                            min = Math.min(dp[i][k] + dp[k + 1][j] + 1, min);
                        }
                        dp[i][j] = min;
                    }
                } else {
                    if (i + 1 == j) {
                        dp[i][j] = 1;
                    } else {
                        int min = Integer.MAX_VALUE;
                        for (int k = i; k < j; k++) {
                            min = Math.min(dp[i][k] + dp[k + 1][j] + 1, min);
                        }
                        dp[i][j] = min;
                    }
                }
                /*System.out.println("dp" + "[" + i + "]" + "[" + j + "]" + "=" + dp[i][j]);*/
            }
        }
        return dp[0][len - 1];
    }

    /**
     * 使用回溯的方法会导致超出时间限制，那么这个时候可以选择的方式有动态规划
     * 以及Manacher算法+区间合并方法
     *
     * @param s
     * @return
     */
    private int minCutByBacktracking(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        List<String> list = new LinkedList<>();
        int[] min = new int[]{s.length() - 1};
        recurPartition(s, 0, list, min);
        return min[0];
    }

    private void recurPartition(String s, int index, List<String> list, int[] min) {
        if (index >= s.length()) {
            int count = list.size() - 1;
            if (count < min[0]) {
                min[0] = count;
            }
            return;
        }
        list.add(s.substring(index, index + 1));
        recurPartition(s, index + 1, list, min);
        list.remove(list.size() - 1);
        for (int i = index + 1; i < s.length(); i++) {
            String substr = s.substring(index, i + 1);
            if (isPalindrome(substr)) {
                list.add(substr);
                recurPartition(s, i + 1, list, min);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
