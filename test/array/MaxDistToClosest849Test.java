package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/20
 */
public class MaxDistToClosest849Test extends TestCase {

    private final MaxDistToClosest849 max = new MaxDistToClosest849();

    public void test1() {
        int result = max.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1});
        Assert.assertEquals(result, 2);
    }

    public void test2() {
        int result = max.maxDistToClosest(new int[]{1, 0, 0, 0});
        Assert.assertEquals(result, 3);
    }

    public void test3() {
        int result = max.maxDistToClosest(new int[]{0, 1});
        Assert.assertEquals(result, 1);
    }
}
