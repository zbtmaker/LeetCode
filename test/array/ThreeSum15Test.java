package array;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author zoubaitao
 * date 2022/03/19
 */
public class ThreeSum15Test extends TestCase {

    private final ThreeSum15 three = new ThreeSum15();

    public void test1() {
        List<List<Integer>> res = three.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        Assert.assertEquals(res.size(), 2);
    }

    public void test2() {
        List<List<Integer>> res = three.threeSum(new int[]{});
        Assert.assertEquals(res.size(), 0);
    }

}
