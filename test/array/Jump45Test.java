package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/15
 */
public class Jump45Test extends TestCase {

    private final Jump45 jump = new Jump45();

    public void test1() {
        int result = jump.jump(new int[]{2, 3, 1, 1, 4});
        Assert.assertEquals(result, 2);
    }

    public void test2() {
        int result = jump.jump(new int[]{2, 3, 0, 1, 4});
        Assert.assertEquals(result, 2);
    }

    public void test3() {
        int result = jump.jump(new int[]{1, 2});
        Assert.assertEquals(result, 1);
    }
}
