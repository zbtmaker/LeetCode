package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/05/30
 */
public class MinSubArrayLen209Test extends TestCase {

    private MinSubArrayLen209 subArray = new MinSubArrayLen209();

    public void test1() {
        int min = subArray.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        Assert.assertEquals(min, 2);
    }
}
