package bit;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/04/30
 */
public class TestReverseBits190 extends TestCase {

    private ReverseBits190 reverse = new ReverseBits190();

    public void test1() {
        Assert.assertEquals(reverse.reverseBits(43261596), 964176192);
    }
}
