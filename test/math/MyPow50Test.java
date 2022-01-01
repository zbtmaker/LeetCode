package math;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class MyPow50Test extends TestCase {
    private final MyPow50 myPow50 = new MyPow50();


    public void test1() {
        double x = -2;
        int n = -3;
        double result = myPow50.myPow(x, n);
        System.out.println(result);
    }

    public void test2() {
        double x = 2;
        int n = 2147483647;
        double result = myPow50.myPow(x, n);
        System.out.println(result);
    }

    public void test3() {
        int n = Integer.MIN_VALUE;
        int m = Math.abs(n);
        System.out.println(n);
        System.out.println(m);
    }
}
