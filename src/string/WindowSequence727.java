package string;

import java.util.Arrays;

/**
 * @author Baitao Zou
 * date 2021/05/09
 */
public class WindowSequence727 {

    public String minWindow(String s, String t) {
        return minWindowByDP(s, t);
    }

    private String minWindowBruteForce(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int min = Integer.MAX_VALUE, start = 0;
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) != t.charAt(0)) {
                continue;
            }
            int tIndex = 0;
            for (int j = i; j < sLen; j++) {
                if (s.charAt(j) == t.charAt(tIndex)) {
                    tIndex++;
                }
                if (tIndex == tLen) {
                    if (min > j - i + 1) {
                        min = j - i + 1;
                        start = i;
                    }
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

    private String minWindowByDP(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int min = Integer.MAX_VALUE, start = 0;
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int[] aux : dp) {
            Arrays.fill(aux, -1);
        }
        for (int i = 1; i < sLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                dp[i][j] = s.charAt(i - 1) == t.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j];
            }
            if (dp[i][tLen] != -1) {
                if (min > i - dp[i][tLen]) {
                    min = i - dp[i][tLen];
                    start = dp[i][tLen];
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
