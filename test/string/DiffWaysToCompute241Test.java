package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/05/02
 */
public class DiffWaysToCompute241Test {

    private DiffWaysToCompute241 diff = new DiffWaysToCompute241();

    @Test
    public void test1() {
        List<Integer> strs = diff.diffWaysToCompute("2-1-1");
        Assert.assertArrayEquals(strs.toArray(new Integer[0]), new Integer[]{2, 0});
    }

    @Test
    public void test2() {
        List<Integer> strs = diff.diffWaysToCompute("2-1");
        Assert.assertArrayEquals(strs.toArray(new Integer[0]), new Integer[]{1});
    }

    @Test
    public void test3() {
        List<Integer> strs = diff.diffWaysToCompute("2*3-4*5");
        System.out.println(Arrays.toString(strs.toArray(new Integer[0])));
        Assert.assertArrayEquals(strs.toArray(new Integer[0]), new Integer[]{-34, -14, -10, -10, 10});
    }
}
