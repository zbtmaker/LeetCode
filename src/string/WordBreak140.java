package string;

import java.util.*;

/**
 * Created by Administrator on 2019\3\19 0019.
 */
public class WordBreak140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakByDynamicProgrammingII(s, wordDict);
    }

    private List<String> wordBreakByDynamicProgrammingI(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (String word : wordDict) {
                int wordLen = word.length();
                if (i - wordLen >= 0
                        && s.substring(i - wordLen, i).equals(word)
                        && dp[i - wordLen]) {
                    dp[i] = true;
                }
            }
        }
        return null;
    }

    /**
     * 这个题目就是WordBreak139的变种，我们为字符串s的每一个位置都记录有多少拆分方式，这里用一个Map存储所有的位置的字符串类型
     * 但是这样的时间复杂度是没有问题的，但是空间复杂度是有问题的，最终空间复杂度爆炸了。
     *
     * @param s
     * @param wordDict
     * @return
     */
    private List<String> wordBreakByDynamicProgrammingII(String s, List<String> wordDict) {
        Map<Integer, List<String>> aux = new HashMap<>();
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            List<String> curList = new LinkedList<>();
            for (String word : wordDict) {
                int wordLen = word.length();
                if (i - wordLen >= 0
                        && s.substring(i - wordLen, i).equals(word)
                        && dp[i - wordLen]) {
                    dp[i] = true;
                    List<String> lastList = aux.get(i - wordLen);
                    if (lastList == null) {
                        curList.add(word);
                    } else {
                        for (String str : lastList) {
                            curList.add(str + " " + word);
                        }
                    }

                }
            }
            aux.put(i, curList);
        }
        List<String> result = aux.get(len);
        return result == null ? new LinkedList<>() : result;
    }


    private List<String> wordBreakByBacktracking(String s, List<String> wordDict) {
        List<List<String>> lists = new LinkedList<>();
        LinkedList<String> list = new LinkedList<>();
        Map<String, Integer> map = putMap(wordDict);
        recurWordBreak(s, 0, wordDict, map, lists, list);
        List<String> result = new LinkedList<>();
        for (List<String> tmp : lists) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.size(); i++) {
                if (i == tmp.size() - 1) {
                    sb.append(tmp.get(i));
                } else {
                    sb.append(tmp.get(i) + " ");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    private void recurWordBreak(String s, int index, List<String> wordDict, Map<String, Integer> map,
                                List<List<String>> results, LinkedList<String> list) {
        if (index == s.length()) {
            results.add(new LinkedList<>(list));
        }
        for (int i = index; i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);
            if (map.containsKey(subStr)) {
                list.add(subStr);
                recurWordBreak(s, i + 1, wordDict, map, results, list);
                list.removeLast();
            }
        }
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
}
