package string;

import java.util.HashSet;
import java.util.Set;

public class RemoveKdigits402 {
    /**
     * 方法一：自底向上进行递归
     * 方法二：自顶向下进行递归
     * 方法三：动态规划
     *
     * @param num 字符串
     * @param k   要删除的字符数
     * @return 删除之后能够构成的最小数字字符串
     */
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        return removeKdigitsByBottomUpEnumeration(num, k);
    }

    /**
     * 自底向上递归操作
     *
     * @param num 字符串
     * @param k   要删除的字符数
     * @return 删除之后能够构成的最小数字字符串
     */
    private String removeKdigitsByBottomUpEnumeration(String num, int k) {
        Set<Integer> indexSet = new HashSet<>(k);
        int[] min = new int[]{Integer.MAX_VALUE};
        recurRemoveKdigits(num, k, 0, 0, indexSet, min);
        return String.valueOf(min[0]);
    }

    /**
     * 自底向上递归主体
     *
     * @param num      字符串
     * @param k        要删除的的字符数
     * @param count    已经删除的字符数
     * @param i        递归当前的位置
     * @param indexSet 要删除的字符索引集合
     * @param min      最小值
     */
    private void recurRemoveKdigits(String num, int k, int count, int i,
                                    Set<Integer> indexSet, int[] min) {
        if (count == k) {
            min[0] = Math.min(min[0], filterIndex(indexSet, num));
        }
        for (int j = i; j < num.length(); j++) {
            indexSet.add(j);
            count++;
            recurRemoveKdigits(num, k, count, j + 1, indexSet, min);
            count--;
            indexSet.remove(j);
        }
    }

    /**
     * 返回已删除的字符串之后的数字
     *
     * @param indexSet 要删除的字符索引集合
     * @param num      字符串
     * @return 删除字符后的数字
     */
    private int filterIndex(Set<Integer> indexSet, String num) {
        StringBuilder sb = new StringBuilder(num.length() - indexSet.size());
        for (int i = 0; i < num.length(); i++) {
            if (indexSet.contains(i)) {
                continue;
            }
            sb.append(num.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }
}
