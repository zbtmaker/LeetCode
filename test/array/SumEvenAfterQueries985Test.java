package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/19
 */
public class SumEvenAfterQueries985Test extends TestCase {
    private final SumEvenAfterQueries985 sum = new SumEvenAfterQueries985();

    public void test1() {
        int[] result = sum.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{
                {1, 0}, {-3, 1}, {-4, 0}, {2, 3}
        });
        Assert.assertArrayEquals(result, new int[]{8, 6, 2, 4});
    }

}
