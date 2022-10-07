package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/10/05
 */
public class ProfitableSchemes879Test extends TestCase {

    private final ProfitableSchemes879 profitable = new ProfitableSchemes879();

    public void test1() {
        int res = profitable.profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3});
        Assert.assertEquals(res, 2);
    }

    public void test2() {
        int res = profitable.profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8});
        Assert.assertEquals(res, 7);
    }
}
