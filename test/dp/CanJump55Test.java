package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/07/12
 */
public class CanJump55Test extends TestCase {

    private final CanJump55 canJump = new CanJump55();

    public void test1() {
        Assert.assertFalse(canJump.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public void test2() {
        Assert.assertTrue(canJump.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
