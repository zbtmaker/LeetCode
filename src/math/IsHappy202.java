package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/01/25
 */
public class IsHappy202 {

    /**
     * 这个题目的第一步主要是将每一位分离出来，然后求平方和。
     * 如果最后得到的结果为1位，那么只有1和7是快乐数。所以
     * 就有了一个循环结束条件，不会导致死循环
     *
     * @param n 目标数
     * @return true-快乐数，false-非快乐数
     */
    public boolean isHappy(int n) {
        while (true) {
            List<Integer> list = numToDigits(n);
            if (list.size() == 1) {
                if (list.get(0) == 1 || list.get(0) == 7) {
                    return true;
                } else {
                    return false;
                }
            } else {
                n = list.stream().mapToInt(i -> i * i).sum();
            }
        }
    }

    /**
     * 将数的每个位分离出来
     *
     * @param n 目标数
     * @return 数的位数
     */
    public List<Integer> numToDigits(int n) {
        List<Integer> list = new ArrayList<>();
        int mul = 10;
        while (n != 0) {
            int quotient = n / mul;
            int res = n % mul;
            list.add(res);
            n = quotient;
        }
        return list;
    }
}
