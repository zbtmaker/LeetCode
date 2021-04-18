package array;

/**
 * @author Baitao Zou
 * date 2021/04/17
 */
public class Compress443 {
    /**
     * 1、使用一个指针pre用来记录当前指针的位置，用cur指针来记录当前从pre到
     * cur位置相同的字符数量。
     * 2、用取余的方式将数字分割成一个char数组。
     *
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        int pre = -1, i = 0, len = chars.length;
        while (i < len) {
            chars[++pre] = chars[i];
            int j = i + 1;
            while (j < len && chars[i] == chars[j]) {
                j++;
            }
            if (j != i + 1) {
                String str = String.valueOf(j - i);
                for (int k = 0; k < str.length(); k++) {
                    chars[++pre] = str.charAt(k);
                }
            }
            i = j;
        }
        return pre + 1;
    }
}
