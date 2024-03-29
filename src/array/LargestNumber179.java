package array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019\3\5 0005.
 */
public class LargestNumber179 {

    /**
     * 任意两个数字比较是进行字符串排序，任意两个字符9和951，如果A.length < A.length，同时
     * String的compareTo方法，9和91首先比较9和9，然后退出循环，然后两者的长度越长越大。因此
     * 91比9要大。
     * 测试例子 A->输入:[30,34]，此时34 > 30
     * 测试例子 B->输入:[9,91]，9 > 91
     * 测试例子 B->输入:[34534534534,345]345 > 34534534534.这里的具体比较情况是，34534534534第一次进行循环，
     * 退出循环以后，我们用34534534534长度为11,345的长度为3，由11 % 3 = 2，因此我们将从345的
     * 5开始循环，也就是比较一下534（从345的第二位开始）和（34534534534534的前s2的长度）345进
     * 行比较得出结果后，如果
     * 算法时间复杂度O(s1.length + s2.length),空间复杂度为O(1)
     * <p>
     * 整个算法的时间复杂度O(NlogN)，空间复杂度O(N)
     *
     * @param nums 数字数组
     * @return 字符串
     */
    public String largestNumber(int[] nums) {
        List<String> list = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted(this::compareTo)
                .collect(Collectors.toList());

        if (list.get(0).equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 比较两个字符串
     *
     * @param s1 字符串数字
     * @param s2 字符串数字
     * @return s1 == s2 返回0， s1 > s2 返回-1， s1 < s2 返回0
     */
    public int compareTo(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int lam = Math.max(len1, len2);//最大长度

        int lim = Math.min(len1, len2);//最小长度

        int k = 0;

        while (k < lam) {
            char c1 = s1.charAt(k % len1);
            char c2 = s2.charAt(k % len2);
            if (c1 != c2) {
                return c1 > c2 ? -1 : 1;
            }
            k++;
        }
        if (lam % lim == 0) {
            return 0;
        }
        if (len1 > len2) {
            int index = len1 % len2;
            int j = 0;
            while (j < lim) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt((j + index) % len2);
                if (c1 != c2) {
                    return c1 > c2 ? -1 : 1;
                }
                j++;
            }
        }

        if (len1 < len2) {
            int index = len2 % len1;
            int j = 0;
            while (j < lim) {
                char c1 = s1.charAt((j + index) % len2);
                char c2 = s2.charAt(j);
                if (c1 != c2) {
                    return c1 - c2 > 0 ? -1 : 1;
                }
                j++;
            }
        }
        return 0;
    }
}
