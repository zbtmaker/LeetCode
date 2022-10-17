package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/10/12
 */
public class DeleteAndEarn740Test extends TestCase {

    private final DeleteAndEarn740 delete = new DeleteAndEarn740();

    public void test1() {
        int ans = delete.deleteAndEarn(new int[]{2, 3, 4});
        Assert.assertEquals(ans, 6);
    }

    public void test2() {
        int ans = delete.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4});
        Assert.assertEquals(ans, 9);
    }
}
