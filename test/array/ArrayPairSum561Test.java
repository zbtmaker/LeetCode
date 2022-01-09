package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/05
 */
public class ArrayPairSum561Test extends TestCase {

    private final ArrayPairSum561 pair = new ArrayPairSum561();

    public void test1() {
        int result = pair.arrayPairSum(new int[]{1, 4, 3, 2});
        Assert.assertEquals(result, 4);
    }
}
