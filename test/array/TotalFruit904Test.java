package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/04/16
 */
public class TotalFruit904Test extends TestCase {
    private final TotalFruit904 total = new TotalFruit904();

    public void test1() {
        int max = total.totalFruit(new int[]{1, 2, 1});
        Assert.assertEquals(max, 3);
    }

    public void test2() {
        int max = total.totalFruit(new int[]{0, 1, 2, 2});
        Assert.assertEquals(max, 3);
    }

    public void test3() {
        int max = total.totalFruit(new int[]{1, 2, 3, 2, 2});
        Assert.assertEquals(max, 4);
    }

    public void test4() {
        int max = total.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4});
        Assert.assertEquals(max, 5);
    }
}
