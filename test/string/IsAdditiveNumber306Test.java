package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/19
 */
public class IsAdditiveNumber306Test {


    private IsAdditiveNumber306 additive = new IsAdditiveNumber306();

    @Test
    public void test1() {
        boolean flag = additive.isAdditiveNumber("123");
        Assert.assertTrue(flag);
    }

    @Test
    public void test2() {
        boolean flag = additive.isAdditiveNumber("112358");
        Assert.assertTrue(flag);
    }

    @Test
    public void test3() {
        boolean flag = additive.isAdditiveNumber("199100199");
        Assert.assertTrue(flag);
    }

    @Test
    public void test4(){
        boolean flag = additive.isAdditiveNumber("");
        Assert.assertFalse(flag);
    }

    @Test
    public void test5(){
        boolean flag = additive.isAdditiveNumber(null);
        Assert.assertFalse(flag);
    }

    @Test
    public void test6(){
        boolean flag = additive.isAdditiveNumber("1");
        Assert.assertFalse(flag);
    }
    @Test
    public void test7(){
        boolean flag = additive.isAdditiveNumber("12");
        Assert.assertFalse(flag);
    }
    @Test
    public void test8(){
        boolean flag = additive.isAdditiveNumber("1234");
        Assert.assertFalse(flag);
    }

    @Test
    public void test9(){
        boolean flag = additive.isAdditiveNumber("12122436");
        Assert.assertTrue(flag);
    }

    @Test
    public void test10(){
        boolean flag = additive.isAdditiveNumber("199001200");
        Assert.assertFalse(flag);
    }
    @Test
    public void test11(){
        boolean flag = additive.isAdditiveNumber("101");
        Assert.assertTrue(flag);
    }
    @Test
    public void test12(){
        boolean flag = additive.isAdditiveNumber("101020305080130210");
        Assert.assertTrue(flag);
    }

    @Test
    public void test13(){
        boolean flag = additive.isAdditiveNumber("000");
        Assert.assertTrue(flag);
    }
}
