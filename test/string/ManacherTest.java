package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/04/30
 */
public class ManacherTest extends TestCase {


    public void test1() {

        int[] radius = Manacher.manacher("cbbd");
        Assert.assertArrayEquals(radius, new int[]{1, 2, 1, 2, 3, 2, 1, 2, 1});
    }

    public void test2() {
        int[] radius = Manacher.manacher("cbbc");
        Assert.assertArrayEquals(radius, new int[]{1, 2, 1, 2, 5, 2, 1, 2, 1});
    }
}
