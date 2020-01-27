package string;


/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class ReverseWords151 {
    /**
     * 这个题目的需要分三步走，第一步就是去除首尾和中间多余的空余blank，
     * 然后第二步就是将整个字符串颠倒过来，第三步是将反转后的字符串遇到的blank
     * 则颠倒相应单词。
     *
     * @param s 目标字符
     * @return 翻转句子和单词的字符串
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chs = deleteRestBlank(s).toCharArray();

        reverseString(chs, 0, chs.length - 1);

        int i = 0;
        while (i < chs.length) {
            int k = i + 1;
            while (k < chs.length && chs[k] != ' ') {
                k++;
            }
            reverseString(chs, i, k - 1);
            i = k + 1;
        }
        return String.valueOf(chs);
    }

    /**
     * 删除头部和尾部的空白
     *
     * @param s 目标方法
     * @return 删除多余空白后的字符串
     */
    private String deleteRestBlank(String s) {
        int head = 0;
        while (head < s.length() && s.charAt(head) == ' ') {
            head++;
        }
        int tail = s.length() - 1;
        while (tail > -1 && s.charAt(tail) == ' ') {
            tail--;
        }
        if (head == s.length() || tail == -1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = head;
        while (i <= tail) {
            int k = i + 1;
            while (k <= tail && s.charAt(k) == ' ' && s.charAt(k) == s.charAt(k - 1)) {
                k++;
            }
            sb.append(s.charAt(i));
            i = k;
        }
        return sb.toString();
    }

    /**
     * @param chs 字符数组
     * @param i   起始位置
     * @param j   结束位置
     */
    private void reverseString(char[] chs, int i, int j) {
        if (chs == null || chs.length == 0) {
            return;
        }
        while (i < j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
    }
}
