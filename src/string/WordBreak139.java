package string;

import java.util.*;

/**
 * Created by Administrator on 2019\3\8 0008.
 */
public class WordBreak139 {

    /**
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakByDynamicProgramming(s, wordDict);
    }

    /**
     * 采用动态规划思想，这个题目其实是和爬楼梯、青蛙过河等问题是一个类型
     * 的题目，这里的问题和爬楼梯是一个思路，只不过这里每一次可以上台阶的次数多了一些。
     *
     * @param s
     * @param wordDict
     * @return
     */
    private boolean wordBreakByDynamicProgramming(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            /*System.out.println(s.substring(0,i));*/
            boolean flag = false;
            for (String word : wordDict) {
                int wordLen = word.length();
                if (i - wordLen >= 0
                        && word.equals(s.substring(i - wordLen, i))
                        && dp[i - wordLen]) {
                    flag = true;
                    break;
                }
            }
            dp[i] = flag;
        }
        return dp[len];
    }

    /**
     * 回溯+HashMap查找,回溯法是耗时最长的，但是是可以解的。或者我们可以用贪心的方式
     *
     * @param s
     * @param wordDict
     * @return
     */
    private boolean wordBreakByBacktracking(String s, List<String> wordDict) {
        Map<String, Integer> map = putMap(wordDict);
        return recurWordBreak(s, 0, map);
    }

    /**
     * 递归的主体
     *
     * @param s
     * @param index
     * @param map
     * @return
     */
    private boolean recurWordBreak(String s, int index, Map<String, Integer> map) {
        if (index == s.length()) {
            return true;
        }
        for (int i = index; i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);
            if (map.containsKey(subStr) && recurWordBreak(s, i + 1, map)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将wordDict中的String放入到HashMap当中，便于查找
     *
     * @param wordDict
     * @return
     */
    private Map<String, Integer> putMap(List<String> wordDict) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : wordDict) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        return map;
    }

    /**
     * 此案例导致我的方案失败
     * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
     * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
     * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa",,"aaaaaaaaa","aaaaaaaaaa"]
     */

    /**
     * 前面我们提到了使用回溯方法解决这个问题，但是在知乎上和算法导论中在介绍
     * 动态规划这种方法时，首先介绍了回溯的方法来解决动态规划的问题，然后是基于
     * 回溯思想并通过记录下面已经计算过的子问题，来减少parent problem中的subproblem.
     * 因此对于一个回溯算法能够解决的问题，一定能够使用动态规划的方法（也就是使用
     * 额外空间的方式来记录已经计算过的过程。）我们这里使用一个数组来表示前面能够在WordList当中
     * 找到的所有的方案。
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreakII(String s, List<String> wordDict) {
        Map<String, Integer> map = putMap(wordDict);
        List<Integer> auxList = new ArrayList<>();
        auxList.add(-1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = auxList.size() - 1; j > -1; j--) {
                String subString = s.substring(auxList.get(j) + 1, i + 1);
                if (map.containsKey(subString)) {
                    auxList.add(i);
                    break;
                }
            }
        }
        return auxList.get(auxList.size() - 1) == s.length() - 1 ? true : false;
    }
}
