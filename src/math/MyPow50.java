package math;


/**
 * Created by Administrator on 2019\3\7 0007.
 */
public class MyPow50 {
    /**
     * 直接运算会超出运算
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double result = pow(x, Math.abs(n));
        if(n < 0) {
            return 1/result;
        }
        return result;
    }

    public double pow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        double result = pow(x, n/2);
        return n % 2 == 0 ? result * result : x * result * result;
    }
}
