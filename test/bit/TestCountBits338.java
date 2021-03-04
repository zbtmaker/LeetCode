package bit;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/03/04
 */
public class TestCountBits338 extends TestCase {

    private CountBits338 count = new CountBits338();

    public void test1() {
        int[] bits = count.countBits(5);
        Assert.assertArrayEquals(bits, new int[]{0, 1, 1, 2, 1, 2});
    }
}
