package math;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 *
 * @author baitao zou
 * date 2020/04/11
 */
public class Divide29 {
    /**
     * 采用的方式是暴力算法和
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        return divideByShift(dividend, divisor);
    }

    /**
     * 移位的方式：其中有一个解读的很好的就是采用泰勒展开式，我们每次都找到divisor的最大倍数factor * divisor < dividend
     * 比如：dividend = 10, divisor = 3;
     * 第一步：factor = 3, factor  * divisor = 9，此时count = count + factor = 3; dividend = dividend - 9 = 1;
     * 第二步：此时dividend < divisor;
     * 那么我们就可以对剩下的继续重复上面的步骤，而结果就是对count += factor;
     *
     * @param dividend
     * @param divisor
     * @return
     */
    private int divideByShift(int dividend, int divisor) {
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);
        if (dividendAbs < divisorAbs) {
            return 0;
        }
        long count = 0;
        while (dividendAbs >= divisorAbs) {
            long countTmp = 1;
            long divisorTmp = divisorAbs;
            while (divisorTmp <= dividendAbs) {
                divisorTmp = divisorTmp << 1;
                countTmp = countTmp << 1;
            }
            divisorTmp = divisorTmp >> 1;
            countTmp = countTmp >> 1;
            dividendAbs -= divisorTmp;
            count += countTmp;
        }
        if ((dividend > 0 && divisor < 0)
                || (dividend < 0 && divisor > 0)) {
            return (int) -count;
        }
        long intMax = Integer.MAX_VALUE;
        if (count == intMax + 1) {
            return Integer.MAX_VALUE;
        }
        return (int) count;
    }

    /**
     * 这里使用最原始的方式，就是使用加法的方式，时间复杂度太高了，所以时间超了
     * * 1、解决一个为正数，一个为负数的问题，所以采用取绝对值的问题
     * * 2、对于Integer.MIN_VALUE取绝对值后会出现溢出问题。
     * * 3、所以对两个数取绝对值之后，用long类型保存。
     *
     * @param dividend
     * @param divisor
     * @return
     */
    private int divideByBruteForce(int dividend, int divisor) {
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);
        long count = 0;
        while (dividendAbs >= divisorAbs) {
            dividendAbs -= divisorAbs;
            count++;
        }
        if ((dividend > 0 && divisor < 0)
                || (dividend < 0 && divisor > 0)) {
            return (int) -count;
        }
        long intMax = Integer.MAX_VALUE;
        if (count == intMax + 1) {
            return Integer.MAX_VALUE;
        }
        return (int) count;
    }
}
