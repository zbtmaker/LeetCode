package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/30
 */
public class ManacherTest {


    @Test
    public void test1() {
        int[] radius = Manacher.manacher("cbbd");
        Assert.assertArrayEquals(radius, new int[]{1, 2, 1, 2, 3, 2, 1, 2, 1});
    }

    @Test
    public void test2() {
        int[] radius = Manacher.manacher("cbbc");
        Assert.assertArrayEquals(radius, new int[]{1, 2, 1, 2, 5, 2, 1, 2, 1});
    }
}
