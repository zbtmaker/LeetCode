package bit;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/03/04
 */
public class HammingDistance461Test extends TestCase {

    private HammingDistance461 distance = new HammingDistance461();

    public void test1() {
        int dist = distance.hammingDistance(1, 4);
        Assert.assertEquals(dist, 2);
    }
}
