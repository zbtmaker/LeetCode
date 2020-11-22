package bit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/11/22
 */
public class ToHex405Test {

    private ToHex405 toHex;

    @Before
    public void before() {
        toHex = new ToHex405();
    }

    @Test
    public void test1() {
        Assert.assertEquals(toHex.toHex(26), "1a");
    }

    @Test
    public void test2() {
        Assert.assertEquals(toHex.toHex(0), "0");
    }

    @Test
    public void test3() {
        Assert.assertEquals(toHex.toHex(-1), "ffffffff");
    }

    @Test
    public void test4() {
        /*System.out.println(15 << 28);*/
    }
}
