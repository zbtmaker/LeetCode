package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/12
 */
public class MajorityElement169Test {
    private MajorityElement169 majority = new MajorityElement169();

    @Test
    public void test1() {
        int result = majority.majorityElement(new int[]{1, 2, 1});
        Assert.assertEquals(result, 1);
    }

    @Test
    public void test2() {
        int result = majority.majorityElement(new int[]{2, 1, 1, 1, 2, 1, 3});
        Assert.assertEquals(result, 1);
    }

    @Test
    public void test3() {
        int result = majority.majorityElement(new int[]{1, 2, 2, 1,1});
        Assert.assertEquals(result, 1);
    }

    @Test
    public void test4() {
        int result = majority.majorityElement(new int[]{2, 3, 1, 1,1});
        Assert.assertEquals(result, 1);
    }
}
