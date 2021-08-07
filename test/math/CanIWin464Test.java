package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/13
 */
public class CanIWin464Test {
    private CanIWin464 win = new CanIWin464();

    @Test
    public void test1() {
        boolean flag = win.canIWin(10, 11);
        Assert.assertFalse(flag);
    }
}
