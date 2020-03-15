package unionfind;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/15
 */
public class EquationsPossible990Test {

    private EquationsPossible990 equal = new EquationsPossible990();

    @Test
    public void test1() {
        boolean flag = equal.equationsPossible(new String[]{"a==b", "b!=a"});
        Assert.assertFalse(flag);
    }

    @Test
    public void test3() {
        boolean flag = equal.equationsPossible(new String[]{"a==b", "b==c", "a==c"});
        Assert.assertTrue(flag);
    }

    @Test
    public void test4() {
        boolean flag = equal.equationsPossible(new String[]{"a==b", "b!=c", "c==a"});
        Assert.assertFalse(flag);
    }

    @Test
    public void test5() {
        boolean flag = equal.equationsPossible(new String[]{"c==c", "b==d", "x!=z"});
        Assert.assertTrue(flag);
    }
}
