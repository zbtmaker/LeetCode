package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/27
 */
public class MinDistance583Test {

    private MinDistance583 minDistance = new MinDistance583();

    @Test
    public void test1() {
        int min = minDistance.minDistance("sea", "eat");
        Assert.assertEquals(min, 2);
    }

}
