package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/24
 */
public class FractionAddition592Test {

    private FractionAddition592 fraction = new FractionAddition592();

    @Test
    public void test1() {
        String result = fraction.fractionAddition("1/2+2/3+3/4");
        Assert.assertEquals(result, "23/12");
    }

    @Test
    public void test2() {
        String result = fraction.fractionAddition("-1/2+1/2");
        Assert.assertEquals(result, "0/1");
    }

    @Test
    public void test3() {
        String result = fraction.fractionAddition("-1/2+1/2+1/3");
        Assert.assertEquals(result, "1/3");
    }

    @Test
    public void test4() {
        String result = fraction.fractionAddition("-1/2+1/3");
        Assert.assertEquals(result, "-1/6");
    }

    @Test
    public void test5() {
        String result = fraction.fractionAddition("1/3-1/2");
        Assert.assertEquals(result, "-1/6");
    }

    @Test
    public void test6() {
        String result = fraction.fractionAddition("5/3+1/3");
        Assert.assertEquals(result, "2/1");
    }

    @Test
    public void test7() {
        String result = fraction.fractionAddition("7/3");
        Assert.assertEquals(result, "7/3");
    }
}
