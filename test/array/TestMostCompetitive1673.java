package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/03/24
 */
public class TestMostCompetitive1673 extends TestCase {

    private MostCompetitive1673 most = new MostCompetitive1673();

    public void test1() {
        int[] result = most.mostCompetitive(new int[]{3, 5, 2, 6}, 2);
        Assert.assertArrayEquals(result, new int[]{2, 6});
    }

    public void test2() {
        int[] result = most.mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4);
        Assert.assertArrayEquals(result, new int[]{2, 3, 3, 4});
    }
}
