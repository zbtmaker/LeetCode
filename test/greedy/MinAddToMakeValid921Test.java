package greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/04
 */
public class MinAddToMakeValid921Test {

    private MinAddToMakeValid921 minAddToMakeValid = new MinAddToMakeValid921();

    @Test
    public void test1() {
        int min = minAddToMakeValid.minAddToMakeValid("()()");
        Assert.assertEquals(min, 0);
    }

    @Test
    public void test2() {
        int min = minAddToMakeValid.minAddToMakeValid("(");
        Assert.assertEquals(min, 1);
    }

    @Test
    public void test3() {
        int min = minAddToMakeValid.minAddToMakeValid("");
        Assert.assertEquals(min, 0);
    }

    @Test
    public void test4() {
        int min = minAddToMakeValid.minAddToMakeValid("()))((");
        Assert.assertEquals(min, 4);
    }

    @Test
    public void test5() {
        int min = minAddToMakeValid.minAddToMakeValid("())");
        Assert.assertEquals(min, 1);
    }
}
