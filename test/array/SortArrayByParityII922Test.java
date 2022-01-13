package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/13
 */
public class SortArrayByParityII922Test extends TestCase {

    private final SortArrayByParityII922 sortArray = new SortArrayByParityII922();

    public void test1() {
        int[] result = sortArray.sortArrayByParityII(new int[]{2, 3, 1, 1, 4, 0, 0, 4, 3, 3});
        Assert.assertArrayEquals(result, new int[]{2, 3, 4, 1, 0, 1, 0, 3, 4, 3});
    }

    public void test2() {
        int[] result = sortArray.sortArrayByParityII(new int[]{});
        Assert.assertArrayEquals(result, new int[]{4, 5, 2, 7});
    }
}
