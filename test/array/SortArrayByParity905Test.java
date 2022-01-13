package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/13
 */
public class SortArrayByParity905Test extends TestCase {

    private final SortArrayByParity905 sortArray = new SortArrayByParity905();

    public void test1() {
        int[] result = sortArray.sortArrayByParity(new int[]{3, 1, 2, 4});
        Assert.assertArrayEquals(result, new int[]{4, 2, 1, 3});
    }
}
