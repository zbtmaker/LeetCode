package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/08/27
 */
public class MaxEnvelopes354Test extends TestCase {

    private final MaxEnvelopes354 maxEnvelopes = new MaxEnvelopes354();

    public void test1() {
        int res = maxEnvelopes.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}});
        Assert.assertEquals(res, 3);
    }

    public void test2() {
        int res = maxEnvelopes.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}});
        Assert.assertEquals(res, 1);
    }


    public void test3() {
        int res = maxEnvelopes.maxEnvelopes(new int[][]{{2, 5}, {2, 7}, {6, 1}, {6, 2}, {6, 3}, {6, 4}, {6, 5}, {6, 6}});
        Assert.assertEquals(res, 2);
    }
}
