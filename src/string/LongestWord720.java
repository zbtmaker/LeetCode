package string;

import java.util.*;

/**
 * @author zoubaitao
 * date 2022/03/17
 */
public class LongestWord720 {

    /**
     * @param words 字符串
     * @return 最长且字典序最小的字符串
     */
    public String longestWord(String[] words) {
        return byRecur(words);
    }

    /**
     * 递归方式，对每一层进行递归，用HashMap统计每一个长度的字符串
     *
     * @param words 字符串
     * @return 最长且字典序最小的字符串
     */
    private String byRecur(String[] words) {
        Map<Integer, List<String>> countMapStr = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 统计每个长度出现的字符串集合，最小长度字符串，最大长度字符串
        for (String w : words) {
            int len = w.length();
            min = Math.min(len, min);
            max = Math.max(len, max);
            List<String> list = countMapStr.computeIfAbsent(w.length(), k -> new LinkedList<>());
            list.add(w);
        }
        if (min != 1) {
            return "";
        }
        // 校验长度是否满足
        List<String> strings = countMapStr.get(min);
        String[] maxStr = new String[]{""};

        for (String str : strings) {
            dfs(str, countMapStr, maxStr);
        }
        return maxStr[0];
    }

    private void dfs(String cur, Map<Integer, List<String>> countMapStr, String[] maxStr) {
        int len = cur.length();
        List<String> strings = countMapStr.get(len + 1);
        boolean flag = false;
        if (strings != null) {
            for (String str : strings) {
                if (str.startsWith(cur)) {
                    flag = true;
                    dfs(str, countMapStr, maxStr);
                }
            }
        }
        if (!flag) {
            String str = maxStr[0];
            if (cur.length() > str.length() || (cur.length() == str.length() && maxStr[0].compareTo(cur) > 0)) {
                maxStr[0] = cur;
            }
        }
    }

    /**
     * 通过前缀树的方式实现
     *
     * @param words 字符串
     * @return 最长且字典序最小的字符串
     */
    private String byTrie(String[] words) {
        return "";
    }
}
