package array;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author zoubaitao
 * date 2022/01/04
 */
public class FindDisappearedNumbers448Test extends TestCase {

    private final FindDisappearedNumbers448 disappear = new FindDisappearedNumbers448();

    public void test1() {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = disappear.findDisappearedNumbers(nums);
        Assert.assertArrayEquals(CommonUtil.listToArr(result), new int[]{5, 6});
    }
}
