package array;

import org.junit.Assert;
import org.junit.Test;

public class RangeBitwiseAnd201Test {
    @Test
    public void test1(){
        rangeBitwiseAnd201 rangeBitWiseAnd201 = new rangeBitwiseAnd201();
        int m = 5;
        int n = 7;
        int result = rangeBitWiseAnd201.rangeBitwiseAnd(m,n);
        Assert.assertEquals(result,0);
    }
    @Test
    public void test2(){
        rangeBitwiseAnd201 rangeBitWiseAnd201 = new rangeBitwiseAnd201();
        int m = 0;
        int n = 1;
        int result = rangeBitWiseAnd201.rangeBitwiseAnd(m,n);
        Assert.assertEquals(result,0);
    }
}
