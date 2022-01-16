package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/16
 */
public class PivotIndex724Test extends TestCase {

    private final PivotIndex724 pivotIndex = new PivotIndex724();

    public void test1() {
        int result = pivotIndex.pivotIndex(new int[]{1, 2, 3});
        Assert.assertEquals(result, -1);
    }

    public void test2() {
        int result = pivotIndex.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        Assert.assertEquals(result, 3);
    }
}
