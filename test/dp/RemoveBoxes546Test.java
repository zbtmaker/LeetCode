package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/10/07
 */
public class RemoveBoxes546Test extends TestCase {

    private final RemoveBoxes546 boxes = new RemoveBoxes546();

    public void test1() {
        int ans = boxes.removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1});
        Assert.assertEquals(ans, 23);
    }

    public void test2() {
        int ans = boxes.removeBoxes(new int[]{1, 1, 1});
        Assert.assertEquals(ans, 9);
    }

    public void test3() {
        int ans = boxes.removeBoxes(new int[]{1});
        Assert.assertEquals(ans, 1);
    }

    public void test4() {
        int ans = boxes.removeBoxes(new int[]{3, 2, 2, 2, 4, 3});
        Assert.assertEquals(ans, 14);
    }
}
