package array;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author zoubaitao
 * date 2022/01/15
 */
public class GetRow119Test extends TestCase {

    private final GetRow119 getRow = new GetRow119();

    public void test1() {
        List<Integer> result = getRow.getRow(3);
        Assert.assertArrayEquals(CommonUtil.listToArr(result), new int[]{1, 3, 3, 1});
    }
}
