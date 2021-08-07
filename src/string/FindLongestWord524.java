package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/08/08
 */
public class FindLongestWord524 {

    /**
     * 第一种方法，对list中的每一个字符串都去判断一下该字符串是不是当前字符串的一个字串，如果是则判断当前字符串的
     * 长度是否大于或者等于该字符串，如果是，则重新new 一个list存放，如果不是，则判断下一个list。这种方式执行的时间太长了。
     * 我们分析一下时间复杂度，基本上就是O(ND),其中N = s.length(), D = d.length;
     *
     * @param s 源字符串
     * @param d 目标字符串集合
     * @return
     */
    public String findLongestWord(String s, List<String> d) {
        int max = 0;
        ArrayList<String> result = new ArrayList<>();
        for (String str : d) {
            IsSubsequence392 subsequence392 = new IsSubsequence392();
            if (subsequence392.isSubsequence(str, s)) {
                int strLen = str.length();
                if (strLen > max) {
                    result = new ArrayList<>();
                    result.add(str);
                    max = strLen;
                } else if (strLen == max) {
                    result.add(str);
                }
            }
        }
        if (result.size() >= 1) {
            result.sort(String::compareTo);
            return result.get(0);
        }
        return "";
    }
}
