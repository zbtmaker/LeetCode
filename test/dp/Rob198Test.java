package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/10
 */
public class Rob198Test {

    private Rob198 rob = new Rob198();

    @Test
    public void test1() {
        int max = rob.rob(new int[]{1, 2, 3, 1});
        Assert.assertEquals(max, 4);
    }
}
