package backtracking;

import backtracking.Change518;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/20
 */
public class Change518Test {

    private Change518 change = new Change518();

    @Test
    public void test1() {
        int result = change.change(5, new int[]{1, 2, 5});
        Assert.assertEquals(result, 4);
    }

    @Test
    public void test2() {
        int result = change.change(3, new int[]{2});
        Assert.assertEquals(result, 0);
    }

    @Test
    public void test3() {
        int result = change.change(10, new int[]{10});
        Assert.assertEquals(result, 1);
    }
}
