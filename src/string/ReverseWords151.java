package string;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class ReverseWords151 {

    public String reverseWords(String s) {
        return reverseWordsI(s);
    }

    /**
     * 这个题目的第一种思路就是把每个字符有效字符串拿出来放入到字符串中，然后对list进行翻转。
     * 这里使用的数据结构是ArrayList。其实如果使用LinkedList是不是会快一些，因为就相当于是
     * 链表的翻转，而且还节省了链表的扩容操作。但是LinkedList并没有提供reverse操作，而且
     * Collections提供的reverse性能其实不怎么样。
     *
     * @param s
     * @return
     */
    private String reverseWordsI(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int i = 0;
        List<String> strings = new ArrayList<>();
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            if (i >= s.length()) {
                break;
            }
            int k = i + 1;
            while (k < s.length() && s.charAt(k) != ' ') {
                k++;
            }
            strings.add(s.substring(i, k));
            i = k;
        }
        int left = 0;
        int right = strings.size() - 1;
        while (left < right) {
            String tmp = strings.get(left);
            strings.set(left, strings.get(right));
            strings.set(right, tmp);
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < strings.size(); m++) {
            sb.append(strings.get(m));
            if (m != strings.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 这个题目的需要分三步走，第一步就是去除首尾和中间多余的空余blank，
     * 然后第二步就是将整个字符串颠倒过来，第三步是将反转后的字符串遇到的blank
     * 则颠倒相应单词。
     *
     * @param s 目标字符
     * @return 翻转句子和单词的字符串
     */
    public String reverseWordsII(String s) {
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
