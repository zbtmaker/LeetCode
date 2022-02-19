package array;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

/**
 * @author zoubaitao
 * date 2022/01/09
 */
public class FindDuplicates442Test extends TestCase {

    private final FindDuplicates442 find = new FindDuplicates442();

    public void test1() {
        List<Integer> result = find.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        Collections.sort(result);
        Assert.assertArrayEquals(CommonUtil.listToArr(result), new int[]{2, 3});
    }

    public void test2() {
        List<Integer> result = find.findDuplicates(new int[]{1, 1, 2});
        Collections.sort(result);
        Assert.assertArrayEquals(CommonUtil.listToArr(result), new int[]{1});
    }

    public void test3() {
        List<Integer> result = find.findDuplicates(new int[]{1});
        Collections.sort(result);
        Assert.assertArrayEquals(CommonUtil.listToArr(result), new int[]{});
    }
}
