package dp;

/**
 * @author baitao zou
 * date 2020/05/08
 */
public class NumDecodings639 {

    public int numDecodings(String s) {
        return numDecodingsByConstant(s);
    }

    /**
     * 自顶向下递归，采用深度优先遍历方式
     *
     * @param s
     * @return
     */
    private int numDecodingsByTopDown(String s) {
        return (int) (numDecodingsByTopDownRecur(s, s.length() - 1) % (Math.pow(10, 9) + 7));
    }

    private long numDecodingsByTopDownRecur(String s, int index) {
        if (index < 0) {
            return 1;
        }
        int sum = 0;

        if (s.charAt(index) == '*') {
            sum += 9 * numDecodingsByTopDownRecur(s, index - 1);
        } else {
            if (s.charAt(index) != '0') {
                sum += numDecodingsByTopDownRecur(s, index - 1);
            }
        }

        if (index - 1 >= 0 && s.charAt(index - 1) != 0) {
            if (s.charAt(index) == '*' && s.charAt(index - 1) == '*') {
                sum += 15 * numDecodingsByTopDownRecur(s, index - 2);
            } else if (s.charAt(index) == '*') {
                if (s.charAt(index - 1) - '0' == 1) {
                    sum += 9 * numDecodingsByTopDownRecur(s, index - 2);
                } else if (s.charAt(index - 1) - '0' == 2) {
                    sum += 6 * numDecodingsByTopDownRecur(s, index - 2);
                }
            } else if (s.charAt(index - 1) == '*') {
                if (s.charAt(index) - '0' <= 6) {
                    sum += 2 * numDecodingsByTopDownRecur(s, index - 2);
                } else {
                    sum += numDecodingsByTopDownRecur(s, index - 2);
                }
            } else {
                if (s.charAt(index - 1) - '0' == 1 || (s.charAt(index - 1) == '2' && s.charAt(index) - '0' <= 6)) {
                    sum += numDecodingsByTopDownRecur(s, index - 2);
                }
            }
        }
        return sum;
    }

    /**
     * 深度优先遍历+Memorization，自顶向下思想
     *
     * @return
     */
    private int numDecodingsByTopDownMemorization(String s) {
        int len = s.length();
        long[] dp = new long[len];
        return (int) (numDecodingsByTopDownMemorizationRecur(s, len - 1, dp) % (Math.pow(10, 9) + 7));
    }

    private long numDecodingsByTopDownMemorizationRecur(String s, int index, long[] dp) {
        if (index < 0) {
            return 1;
        }
        if (dp[index] != 0) {
            return dp[index];
        }

        int sum = 0;

        if (s.charAt(index) == '*') {
            sum += 9 * numDecodingsByTopDownMemorizationRecur(s, index - 1, dp);
        } else {
            if (s.charAt(index) != '0') {
                sum += numDecodingsByTopDownMemorizationRecur(s, index - 1, dp);
            }
        }

        if (index - 1 >= 0 && s.charAt(index - 1) != 0) {
            if (s.charAt(index) == '*' && s.charAt(index - 1) == '*') {
                sum += 15 * numDecodingsByTopDownMemorizationRecur(s, index - 2, dp);
            } else if (s.charAt(index) == '*') {
                if (s.charAt(index - 1) - '0' == 1) {
                    sum += 9 * numDecodingsByTopDownMemorizationRecur(s, index - 2, dp);
                } else if (s.charAt(index - 1) - '0' == 2) {
                    sum += 6 * numDecodingsByTopDownMemorizationRecur(s, index - 2, dp);
                }
            } else if (s.charAt(index - 1) == '*') {
                if (s.charAt(index) - '0' <= 6) {
                    sum += 2 * numDecodingsByTopDownMemorizationRecur(s, index - 2, dp);
                } else {
                    sum += numDecodingsByTopDownMemorizationRecur(s, index - 2, dp);
                }
            } else {
                if (s.charAt(index - 1) - '0' == 1 || (s.charAt(index - 1) == '2' && s.charAt(index) - '0' <= 6)) {
                    sum += numDecodingsByTopDownMemorizationRecur(s, index - 2, dp);
                }
            }
        }
        dp[index] = sum;
        return dp[index];
    }

    /**
     * 自底向上循环，借助DP数组存储结果
     *
     * @return
     */
    private int numDecodingsByUpDown(String s) {
        int len = s.length();
        long[] dp = new long[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) == '*') {
                dp[i] += 9 * dp[i - 1];
            } else {
                if (s.charAt(i - 1) != '0') {
                    dp[i] += dp[i - 1];
                }
            }
            if (i - 2 >= 0 && s.charAt(i - 2) != 0) {
                if (s.charAt(i - 1) == '*' && s.charAt(i - 2) == '*') {
                    dp[i] += 15 * dp[i - 2];
                } else if (s.charAt(i - 1) == '*') {
                    if (s.charAt(i - 2) - '0' == 1) {
                        dp[i] += 9 * dp[i - 2];
                    } else if (s.charAt(i - 2) - '0' == 2) {
                        dp[i] += 6 * dp[i - 2];
                    }
                } else if (s.charAt(i - 2) == '*') {
                    if (s.charAt(i - 1) - '0' <= 6) {
                        dp[i] += 2 * dp[i - 2];
                    } else {
                        dp[i] += dp[i - 2];
                    }
                } else {
                    if (s.charAt(i - 2) - '0' == 1 || (s.charAt(i - 2) == '2' && s.charAt(i - 1) - '0' <= 6)) {
                        dp[i] += dp[i - 2];
                    }
                }
            }
        }
        return (int) (dp[len] % (Math.pow(10, 9) + 7));
    }

    /**
     * @param s 字符串
     * @return 能够拼成总数
     */
    private int numDecodingsByConstant(String s) {
        return 0;
    }
}
