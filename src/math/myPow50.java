package math;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2019\3\7 0007.
 */
public class MyPow50 {
    public static void main(String[] args) {
        double mul = new MyPow50().myPow(2, 0);
        System.out.println(mul);
    }

    /**
     * 用这种方法会出现超出时间限制，那么怎么加快运算
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int m = Math.abs(n);
        double mul = 1;
        for (int i = 1; i <= m; i++) {
            mul *= x;
        }
        return n < 0 ? 1 / mul : mul;
    }

    public double myPowI(double x, int n) {
        if (x == 0 && n < 0) {
            throw new ArithmeticException("分母不能为零");
        }
        if (x == 0) {
            return 0d;
        }
        if (x == 1) {
            return 1d;
        }
        if (n == 0) {
            return 1d;
        }
        int exponent;
        if (n == Integer.MIN_VALUE) {
            exponent = Math.abs(n + 1);
        } else {
            exponent = Math.abs(n);
        }

        double result = recurMyPow(x, exponent);
        if (n == Integer.MIN_VALUE) {
            return 1 / (result * x);
        }else if(n < 0){
            return 1/ result;
        }
        return result;
    }

    public double recurMyPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        //除2得商
        int quotient = n >> 1;
        //除2得余
        int res = n % 2;
        double result = recurMyPow(x, quotient);
        result = result * result;
        if (res == 1) {
            result = result * x;
        }
        return result;
    }
}
