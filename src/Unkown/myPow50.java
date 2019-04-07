package Unkown;

/**
 * Created by Administrator on 2019\3\7 0007.
 */
public class myPow50 {
    public static void main(String[] args){
        double mul = new myPow50().myPow(2,0);
        System.out.println(mul);
    }

    /**
     * 用这种方法会出现超出时间限制，那么怎么加快运算
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        int m = Math.abs(n);
        double mul = 1;
        for(int i = 1;i<=m;i++){
            mul *= x;
        }
        return n < 0 ? 1 / mul : mul;
    }
}
