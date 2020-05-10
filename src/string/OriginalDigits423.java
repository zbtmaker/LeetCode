package string;


/**
 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 * 输入只包含小写英文字母。
 * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
 * 输入字符串的长度小于 50,000。
 * <p>
 * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
 *
 * @author baitao zou
 * date 2020/05/10
 */
public class OriginalDigits423 {
    /**
     * 0 : zero
     * 1 : one
     * 2 : two
     * 3 : three
     * 4 : four
     * 5 : five
     * 6 : six
     * 7 : seven
     * 8 : eight
     * 9 : nine
     * 第一波：根据z-0,w-2,u-4,x-6,g-8
     * 第二波：根据o-1,r-3,f-5,s-7,i-9
     * 其实这个题目主要是要找到某一个数字的英文单词中的某一个字符能够确定，这样就能够先确定一批，然后根据已经确定的数字，
     * 找到下一批数字中唯一的数字，这样就能确定所有的数字。其实这道题应该只能算是easy。
     *
     * @param s
     * @return
     */
    public String originalDigits(String s) {
        int[] charCount = charCount(s);
        int[] numCount = numCount(charCount);
        return numCountToStr(numCount);
    }

    private int[] charCount(String s) {
        int[] charCount = new int[26];
        //统计每个字母的数量
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        return charCount;
    }

    private int[] numCount(int[] charCount) {
        int[] numCount = new int[10];
        numCount[0] = charCount['z' - 'a'];
        numCount[2] = charCount['w' - 'a'];
        numCount[4] = charCount['u' - 'a'];
        numCount[6] = charCount['x' - 'a'];
        numCount[8] = charCount['g' - 'a'];
        numCount[1] = charCount['o' - 'a'] - numCount[0] - numCount[2] - numCount[4];
        numCount[3] = charCount['r' - 'a'] - numCount[4] - numCount[0];
        numCount[5] = charCount['f' - 'a'] - numCount[4];
        numCount[7] = charCount['s' - 'a'] - numCount[6];
        numCount[9] = charCount['i' - 'a'] - numCount[5] - numCount[6] - numCount[8];
        return numCount;
    }

    private String numCountToStr(int[] numCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < numCount[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
