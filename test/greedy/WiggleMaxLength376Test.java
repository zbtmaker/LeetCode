package greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/04
 */
public class WiggleMaxLength376Test {
    private WiggleMaxLength376 wiggleMaxLength = new WiggleMaxLength376();

    @Test
    public void test1() {
        int max = wiggleMaxLength.wiggleMaxLength(new int[]{1, 1});
        Assert.assertEquals(max, 1);
    }

    @Test
    public void test2() {
        int max = wiggleMaxLength.wiggleMaxLength(new int[]{1, 2});
        Assert.assertEquals(max, 2);
    }

    @Test
    public void test3() {
        int max = wiggleMaxLength.wiggleMaxLength(new int[]{3, 2});
        Assert.assertEquals(max, 2);
    }

    @Test
    public void test4() {
        int max = wiggleMaxLength.wiggleMaxLength(new int[]{1});
        Assert.assertEquals(max, 1);
    }

    @Test
    public void test5() {
        int max = wiggleMaxLength.wiggleMaxLength(new int[]{});
        Assert.assertEquals(max, 0);
    }

    @Test
    public void test6() {
        int max = wiggleMaxLength.wiggleMaxLength(new int[]{1, 2, 3, 4});
        Assert.assertEquals(max, 2);
    }

    @Test
    public void test7() {
        int max = wiggleMaxLength.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5});
        Assert.assertEquals(max, 6);
    }

    @Test
    public void test8() {
        int max = wiggleMaxLength.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8});
        Assert.assertEquals(max, 7);
    }
}
