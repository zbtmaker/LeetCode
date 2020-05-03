package math;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * Created by Administrator on 2019\3\7 0007.
 */
public class IsPalindrome9 {
    public boolean isPalindrome(int x) {
        return isPalindromeIII(x);
    }


    /**
     * 第三种方式是直接将一个数字翻转了，然后与原来的数字进行比较，
     * 如果相等，则是回文，如果不想等，则不是回文。明天还可以优化
     * 一下，只求翻转一半的数字，这样能够缩短一半的时间。
     *
     * @param x
     * @return
     */
    private boolean isPalindromeIII(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x;
        long y = 0;
        while (tmp > 0) {
            y = y * 10 + (tmp % 10);
            tmp /= 10;
        }
        return y == x;
    }

    /**
     * 第一种方式通过将数字转换成数组的方式，但是其实我们没必要
     * 这么左，其实我们只要找到一个数的最高位能够整除的factor，这个
     * factor是10的倍数。相当于找到两个指针，然后进行判断。这种方式依然没哟解决问题。
     * 121 121 / 10 = 12 ; 121 / 100 = 1 121
     * 一、
     * leftX / leftFactor = 1, leftX = leftX % leftFactor = 21, leftFactor = leftFactor / 10 = 10;
     * rightX % rightFactor = 1, rightX = rightX / rightFactor = 12;
     * 二、
     * leftX / leftFactor = 2, leftX = leftX % leftFactor = 1, leftFactor = leftFactor / 10 = 1;
     * rightX % rightFactor = 2, rightX = rightX / rightFactor = 1;
     * 三、
     * leftX / leftFactor = 1, leftX = leftX % leftFactor = 0,leftFactor = leftFactor / 10 = 0;
     * rightX % rightFactor = 1,rightX = rightX / rightFactor = 0;
     *
     * @param x
     * @return
     */
    private boolean isPalindromeII(int x) {
        if (x < 0) {
            return false;
        }
        int factor = 1;
        while (x / factor >= 10) {
            factor = factor * 10;
        }
        int leftX = x;
        int rightX = x;
        int leftFactor = factor;
        int rightFactor = 10;
        while (leftFactor > 0 && rightX > 0) {
            if (leftX / leftFactor != rightX % rightFactor) {
                return false;
            }
            leftX = leftX % leftFactor;
            leftFactor /= 10;
            rightX /= rightFactor;
        }
        return true;
    }

    /**
     * 不通过将数字转换成字符串,而是将每个数字转换成一个数组，然后
     * 判断数组是否是一个回文。
     *
     * @param x
     * @return
     */
    private boolean isPalindromeI(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = numToList(x);
        return validatePalindrome(list);
    }

    /**
     * 将每个数字转换成字符串
     *
     * @return
     */
    private List<Integer> numToList(int x) {
        List<Integer> list = new ArrayList<>();
        if (x == 0) {
            list.add(x);
            return list;
        }
        int factor = 10;
        while (x != 0) {
            list.add(x % factor);
            x /= 10;
        }
        return list;
    }

    /**
     * 校验一个数组是否是一个回文
     *
     * @param list 数组链表
     * @return true-回文 ｜ false-非回文
     */
    private boolean validatePalindrome(List<Integer> list) {
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
