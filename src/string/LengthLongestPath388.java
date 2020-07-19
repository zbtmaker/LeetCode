package string;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author baitao zou
 * date 2020/07/19
 */
public class LengthLongestPath388 {

    /**
     * 这就是一个栈的思想就可以解决，我们首先将input字符串用split("/n")进行分割，
     * 然后依次进行入栈操作，什么时候该出栈呢，就是当前字符串和前一个字符串的"/t"
     * 一样多的时候，先将前一个字符串出栈然后当前字符串再进栈。这里我用一个record
     * 的二维数组来记录每个字符串中包含record[i][0]记录"\t"的数量和record[i][1]
     * 记录文件夹名字的长度。
     *
     * @param input
     * @return
     */
    public int lengthLongestPath(String input) {
        String[] strArr = input.split("\n");
        int[][] record = new int[strArr.length][2];
        Stack<int[]> stack = new Stack<>();
        int i = 0;
        int max = 0;
        int count = 0;
        for (String str : strArr) {
            int index = str.lastIndexOf("\t");
            record[i][0] = index + 1;
            record[i][1] = str.length() - index - 1;
            if (stack.isEmpty()) {
                count += record[i][1];
            } else {
                while (!stack.isEmpty() && stack.peek()[0] >= record[i][0]) {
                    int[] tmp = stack.pop();
                    count = count - 1 - tmp[1];
                }
                count += record[i][1] + 1;
            }
            stack.push(record[i]);
            if (str.contains(".")) {
                max = Math.max(count, max);
            }
            i++;
        }
        return max;
    }

    /**
     * 这个功能相当于重新实现了一遍String的split方法
     *
     * @param str
     * @return
     */
    private List<String> splitStr(String str) {
        List<String> list = new LinkedList<>();
        int i = 0;
        int k = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '\n') {
                list.add(str.substring(k, i));
                i++;
                k = i;
            } else {
                i++;
            }
        }
        if (i != k) {
            list.add(str.substring(k, i));
        }
        return list;
    }
}
