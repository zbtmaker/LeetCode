package string;

/**
 * 给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。
 * 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 * 链接：https://leetcode-cn.com/problems/fraction-addition-and-subtraction
 * tag: String、Math
 *
 * @author baitao zou
 * date 2020/03/24
 */
public class FractionAddition592 {

    private static final char OBELUS = '/';

    private static final char ZERO = '0';

    private static final char NINE = '9';

    /**
     * 这个题目和之前的字符串进行运算，但是这个题目考察的地方有最大公约数和最小公倍数，这个题目还是很好的。
     * 后面这个题目可以作为面试题来解决这个问题。或这进行改编。将之前的整数四则运算改成分数四则运算，也是
     * 一个很好的题目。
     *
     * @param expression 分数求和表达式
     * @return
     */
    public String fractionAddition(String expression) {
        int[] lastNum = new int[]{0, 1};
        if (expression == null || expression.length() == 0) {
            return String.valueOf(lastNum[0]) + OBELUS + lastNum[1];
        }
        int[] curNum = new int[]{-1, -1};
        char operator = ' ';
        int len = expression.length();
        int i = 0;
        while (i < len) {
            int k = i + 1;
            while (k < len && expression.charAt(k) >= ZERO && expression.charAt(k) <= NINE) {
                k++;
            }
            Integer num = Integer.parseInt(expression.substring(i, k));
            if (k >= len || (expression.charAt(k) == '+' || expression.charAt(k) == '-')) {
                curNum[1] = num;
                if (operator == '+') {
                    addition(lastNum, curNum);
                } else if (operator == '-') {
                    curNum[0] = -curNum[0];
                    addition(lastNum, curNum);
                } else {
                    lastNum[0] = curNum[0];
                    lastNum[1] = curNum[1];
                }
                if (k >= len) {
                    break;
                }
                operator = expression.charAt(k);
            } else {
                curNum[0] = num;
            }
            i = k + 1;
        }
        if (lastNum[0] == 0) {
            lastNum[1] = 1;
        } else {
            int divisor;
            if (lastNum[0] < 0) {
                divisor = greatestCommonDivisor(-lastNum[0], lastNum[1]);
            } else {
                divisor = greatestCommonDivisor(lastNum[0], lastNum[1]);
            }
            lastNum[0] = lastNum[0] / divisor;
            lastNum[1] = lastNum[1] / divisor;
        }
        return String.valueOf(lastNum[0]) + OBELUS + lastNum[1];
    }

    /**
     * 分数相加
     *
     * @param lastNum 第一个数
     * @param curNum  第二个数
     */
    private void addition(int[] lastNum, int[] curNum) {
        int multiple = leastCommonMultiple(lastNum[1], curNum[1]);
        lastNum[0] = lastNum[0] * (multiple / lastNum[1]) + curNum[0] * (multiple / curNum[1]);
        lastNum[1] = multiple;
    }

    /**
     * 最小公倍数
     *
     * @param a 数a
     * @param b 数b
     * @return a 和 b的最小公倍数
     */
    private int leastCommonMultiple(int a, int b) {
        if (a == b) {
            return a;
        }
        return a * b / greatestCommonDivisor(a, b);
    }

    /**
     * 求解最大公约数
     *
     * @param a 数a
     * @param b 数b
     * @return a 和 b的最大公约数
     */
    private int greatestCommonDivisor(int a, int b) {
        if (a == b) {
            return a;
        }
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int res = max - min;
        while (res != min) {
            max = Math.max(res, min);
            min = Math.min(res, min);
            res = max - min;
        }
        return res;
    }
}
