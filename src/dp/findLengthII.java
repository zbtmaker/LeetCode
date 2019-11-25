package dp;

/**
 * Created by Administrator on 2019\1\24 0024.
 * 题目描述：给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。这里需要的公共子序列，是不需要连续的。
 * 需要注意子串表示连续的，而子序列表示不需要连续的。
 */
public class findLengthII {
    public int longestCommonString(String str1,String str2){
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = new int[chs1.length+1][chs2.length+1];
        return 0;
    }
}
