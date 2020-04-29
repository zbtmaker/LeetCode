package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baitao zou
 * date 2020/04/28
 */
public class IsMatch10 {

    public boolean isMatch(String s, String p) {
        return isMatchByTwoDimensionDP(s, p);
    }

    /**
     * 这个题目我们确定要使用动态规划的算法来实现，对于动态规划的算法，我们按照三步的思想来实现
     * step1：定义
     * 我们按照三步走，第一步，对于字符串的很多题，我们采用动态规划的算法都是采用二维数组，
     * step1： 给定字符串s、p，lenS = s.length(), lenP = p.length()；我们定义二维数组dp[][] = new int[lenP + 1][lenS + 1]。
     * 对于任意的0<=i<=lenP, 0 <= j <= lenS，有dp[i][j] = true表示长度为i的p字符串能够匹配长度为s的字符串。
     * 那么我们就是要找到dp[i][j]和dp[i-1][j-1],dp[i][j-1],dp[i-1][j]之间的关系。（很不幸的是我们这里并不只是这么简单的关系）
     * step2：寻找状态转移方程
     * 做动态规划寻找状态转移方程最笨的方法就是填表法，因为通过填表法可以总结出来状态转移方程，用于字符串的动态规划题目屡试不爽。我们可以通过三个例子
     * 就能找到dp[i][j]和历史数据之间的关系，test case1 s="mississip"，p="mis*is*p*."，test case2 s="mississippi", p="mis*is*p*',test case3 s="aaa", p="ac*ab*a"
     * 就是通过这三个test case就能找到，其中我们需要定义两个Map来辅助存储一些信息。一个是charMap，charMap用来存每一个'*'前面离当前'*'位置最近的第一个不为'*'的字符，例如ac**,charMap会存储(2,'c')，(3,'c')。因为字符串位置
     * 为2的字符串前面第一个不为'*'的字符是'c'。另一个是indexMap，为什么需要这个呢，都是因为'*'这个字符的定义是可以匹配前面零个字符或多个字符，因此"ac*"，可以表示为{a,ac,acc,accc..}等，这个例子中indexMap存储的就是(2,0),这里
     * 存储的就是'*'前面第一个不为'*'字符再前面一个字符的索引，也就是c字符前面一个字符的a的索引就是0。这个主要在推导test case3新增的一个数据结构。
     * 1、我们可以讨论p.charAt(i-1) != '*',但是p.charAt(i-1) == '.' || p.charAt(i-1) == s.charAt(j-1).表示长度为i的字符串p第i个字符和s的第j个字符串匹配了。那么
     * 我们0-i和0-j能否匹配就是看dp[i-1][j-1]是否匹配，如果能够匹配上，那么长度为j的字符串s和模式字符串p匹配上了。
     * 2、我们来讨论最复杂的情况，就是当p.charAt(i-1) == '*'的时候，这个时候我们要分四种情况讨论。
     * case1：dp[i][j]和dp[i-1][j]的关系。如果dp[i-1][j]=true，表示长度为[i-1的模式字符串p和长度为j的字符串s能够匹配上，那么此时长度为i的模式字符串此时只是多了第i位的字符串'*'。
     * 我们根据定义可以知道，'*'可以匹配零个和多个前面的字符，因为前面已经匹配上了那么我们的'*'和前面的第一个不为'*'表示为charMap.get(i-1)，因为charMap.get(i-1) == s.charAt(j-1)。
     * dp[i][j] = dp[i-1][j]。
     * 所以只要有dp[i-1][j] = true,那么dp[i][j] = true.
     * case2：dp[i][j]和dp[i-1][j-1]的关系。如果dp[i-1][j-1]=true，表示长度为i-1的模式字符串和长度为j-1的字符串匹配上了，那么只要i位置前面第一个不为'*'的字符tmp能够和s第j位的字符匹配就行了。
     * 因此可以表示为charMap.get(i-1)表示第i位置之前i-1...0,第一个不为'*'的字符串，只要charMap.get(i-1)==s.charAr(j-1)。此时的相等要分为两种情况，第一种是如果charMap.get(i-1) == '.'，因此
     * s.charAt(j-1)无论为什么都可以匹配，另一种情况是如果charMap.get(i-1)是一个普通的字符串，那么此时就需要满足s.charAt(j-1) == charMap.get(i-1)。
     * case3：dp[i][j]和dp[i][j-1]之前的关系，如果charMap.get(i-1)=='.'或者是charMap.get(i-1) == s.charAt(j-1)。那么此时如果dp[i][j-1]是true的话，而且还是重复的字符的话，那么这个时候肯定是能匹配的。这个例子
     * 主要是从test case2得到的。
     * case4：dp[i][j]和dp[indexMap.get(i-1) + 1][j]之间的关系，如果dp[indexMap.get(i-1)+1][j] = true，那么此时dp[i][j] = true的。
     * 综上四种情况就能得总的递推关系
     * <p>
     * step3：定义初始值，
     * 那么对于1 < j <= lenS,对于dp[0][j]和dp[0][j-1]之间有什么关系。其实就是找到p="",s不为空时要匹配的结果。此时我们知道无法匹配，所以对于dp[0][0] = true,dp[0][j]默认都是false的，不需要处理。
     * 对于1 <= i <= lenP，dp[i][0]和dp[i-1][0]，其实就是要找到s = ""，p不为空时，匹配结果。给定s=""，p="c*a*",此时匹配上了，否则s=""，p="c*ab*"，没有匹配上。根据这个例子可以得到s=""时的初始值。
     * 综上两个就可以得到所有的初始值。关于初始值的代码可以看下面的initDPArr方法。这方法的主要思想是，如果一个'*'前面有大于1个的非'*'字符，那么'*'这个位置和后面的位置都是false，表示不能匹配。
     *
     * @param s
     * @param p
     * @return
     */
    private boolean isMatchByTwoDimensionDP(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenP + 1][lenS + 1];
        initDPArr(p, dp);
        Map<Integer, Character> charMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        getStarLastChar(p, charMap, indexMap);

        int i = 1;
        while (i <= lenP) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            i++;
        }
        for (; i <= lenP; i++) {
            for (int j = 1; j <= lenS; j++) {
                char charP = p.charAt(i - 1);
                char charS = s.charAt(j - 1);
                if (charP == '*') {
                    if (charMap.get(i - 1) == '.' || charMap.get(i - 1) == charS) {
                        dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
                    }
                    if (dp[indexMap.get(i - 1) + 1][j]) {
                        dp[i][j] = true;
                    }
                } else if (charP == '.' || charP == charS) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[lenP][lenS];
    }

    private void getStarLastChar(String p, Map<Integer, Character> charMap, Map<Integer, Integer> indexMap) {
        int k = p.length() - 1;
        while (k >= 0) {
            int i = k - 1;
            if (p.charAt(k) == '*') {
                while (i >= 0) {
                    if (p.charAt(i) != '*') {
                        break;
                    }
                    i--;
                }
                if (i >= 0) {
                    char tmp = p.charAt(i);
                    for (int j = k; j > i; j--) {
                        charMap.put(j, tmp);
                        indexMap.put(j, i - 1);
                    }
                }
            }
            k = i;
        }
    }

    private void initDPArr(String p, boolean[][] dp) {
        int count = 0;
        int i = 1;
        dp[0][0] = true;
        while (i <= p.length()) {
            if (p.charAt(i - 1) == '*') {
                if (count <= 1) {
                    dp[i][0] = true;
                    count = 0;
                } else {
                    break;
                }
            } else {
                count++;
            }
            i++;
        }
    }
}
