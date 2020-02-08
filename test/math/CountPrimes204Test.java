package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/08
 */
public class CountPrimes204Test {
    private CountPrimes204 prime = new CountPrimes204();

    @Test
    public void test1() {
        int count = prime.countPrimes(10);
        Assert.assertEquals(count, 4);
    }

    @Test
    public void test2() {
        int count = prime.countPrimes(11);
        Assert.assertEquals(count, 4);
    }

    @Test
    public void test3() {
        int count = prime.countPrimes(1);
        Assert.assertEquals(count, 0);
    }

    @Test
    public void test4() {
        int count = prime.countPrimes(2);
        Assert.assertEquals(count, 0);
    }

    @Test
    public void test5() {
        int count = prime.countPrimes(1500000);
        Assert.assertEquals(count, 114155);
    }
}
