package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 *
 * @author baitao zou
 * date 2020/03/22
 */
public class Convert6 {

    /**
     * 就是寻找相应的规律,首先使用二维数组的方式实现问题。但是通过参考这位同学的解法
     * https://leetcode-cn.com/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/
     * 一下子就明白了原来这个题目还有这么好的方法
     *
     * @param s       目标字符串
     * @param numRows 行数
     * @return
     */
    public String convert(String s, int numRows) {
        return convertByList(s, numRows);
    }

    /**
     * 采用二维数组的方式解决问题，这种方式需要首先计算出数组的列，然后构造二维数组
     * 再进行遍历。time complexity  和 space complexity 都是O(N^2),待改进
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convertByTwoDimensionArray(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1 || numRows >= s.length()) {
            return s;
        }
        int len = s.length();
        int col = calcCol(len, numRows);
        String[][] matrix = new String[numRows][col];

        int i = 0;
        int tmpCol = 0;
        while (i < len) {
            //列
            int j = 0;
            while (i < len && j < numRows) {
                matrix[j][tmpCol] = String.valueOf(s.charAt(i));
                i++;
                j++;
            }
            tmpCol++;
            int k = 0;
            while (i < len && k < numRows - 2) {
                matrix[numRows - 2 - k][tmpCol] = String.valueOf(s.charAt(i));
                tmpCol++;
                i++;
                k++;
            }
        }
        StringBuilder sb = new StringBuilder(len);
        for (String[] strs : matrix) {
            for (String str : strs) {
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    private int calcCol(int len, int numRows) {
        int col = 0;
        int i = 1;
        while (i <= len) {
            i += numRows;
            col++;
            int k = 0;
            while (i <= len && k < numRows - 2) {
                col++;
                i++;
                k++;
            }
        }
        return col;
    }

    /**
     * 参考方案
     * https://leetcode-cn.com/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/
     * 给定str = "LEETCODE", numRows = 3;
     * L     C
     * E  T  O  E
     * E     D
     * 从上到下的时候就往每个列表的StringBuilder中插入元素，而从下往上就是往中间的StringBuilder插入元素。
     * sb1 = "LC"
     * sb2 = "ETOE"
     * sb3 = "ED"
     * 最终的结果就是sb1+sb2+sb3
     *
     * @param s
     * @param numRows
     * @return
     */
    private String convertByList(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1 || numRows > s.length()) {
            return s;
        }
        int len = s.length();
        List<StringBuilder> list = initStringBuilderList(Math.min(len, numRows));
        int i = 0;
        while (i < len) {
            //列
            int j = 0;
            while (i < len && j < numRows) {
                list.get(j).append(s.charAt(i));
                i++;
                j++;
            }
            int k = 0;
            while (i < len && k < numRows - 2) {
                list.get(numRows - 2 - k).append(s.charAt(i));
                i++;
                k++;
            }
        }
        StringBuilder result = new StringBuilder(len);
        for (StringBuilder sb : list) {
            result.append(sb);
        }
        return result.toString();
    }

    /**
     * @param row 实际需要的行数
     * @return
     */
    private List<StringBuilder> initStringBuilderList(int row) {
        List<StringBuilder> list = new ArrayList<>(row);
        for (int i = 0; i < row; i++) {
            list.add(new StringBuilder());
        }
        return list;
    }
}
