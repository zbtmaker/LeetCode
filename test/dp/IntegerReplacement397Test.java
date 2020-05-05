package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/05
 */
public class IntegerReplacement397Test {

    private IntegerReplacement397 replacement = new IntegerReplacement397();

    @Test
    public void test1() {
        int min = replacement.integerReplacement(1);
        Assert.assertEquals(min, 0);
    }

    @Test
    public void test2() {
        int min = replacement.integerReplacement(7);
        Assert.assertEquals(min, 4);
    }

    @Test
    public void test3() {
        int min = replacement.integerReplacement(8);
        Assert.assertEquals(min, 3);
    }
}
