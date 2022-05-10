package array;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author zoubaitao
 * date 2022/03/12
 */
public class CountSmaller315Test extends TestCase {

    private final CountSmaller315 count = new CountSmaller315();

    public void test1() {
        List<Integer> result = count.countSmaller(new int[]{5, 2, 6, 1});
        Assert.assertArrayEquals(CommonUtil.listToArr(result), new int[]{2, 1, 1, 0});
    }

    public void test2() {
        List<Integer> result = count.countSmaller(new int[]{-1});
        Assert.assertArrayEquals(CommonUtil.listToArr(result), new int[]{0});
    }

    public void test3() {
        List<Integer> result = count.countSmaller(new int[]{-1, -1});
        Assert.assertArrayEquals(CommonUtil.listToArr(result), new int[]{0, 0});
    }
}
