package string;

/**
 * @author baitao zou
 * date 2019\3\10 0010.
 */
public class LengthOfLastWord58 {

    /**
     * 其实这个题目主要是理解题意就是要理解什么是最后一个单词的长度。
     * 每次我们遇到字符' '，就应该跳过，或者是这个' '之前的子字符串，然后继续统计下一个
     * 不为空的字符串的长度，并更新。同时我们在遇到结尾处也应该更新一下最后一个字符串的
     * 长度。
     *
     * @param s 目标字符串
     * @return 最后一个字符串的长度
     */
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int lastLen = 0;
        int i = 0;
        while (i < len) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            int k = i + 1;
            while (k < len && s.charAt(k) != ' ') {
                k++;
            }
            lastLen = k - i;
            i = k + 1;
        }
        return lastLen;
    }
}
