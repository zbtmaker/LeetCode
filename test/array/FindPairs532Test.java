package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/03/26
 */
public class FindPairs532Test extends TestCase {

    private final FindPairs532 find = new FindPairs532();

    public void test1() {
        int result = find.findPairs(new int[]{1, 2, 3, 4, 5}, 1);
        Assert.assertEquals(result, 4);
    }

    public void test2() {
        int result = find.findPairs(new int[]{3, 1, 4, 1, 5}, 2);
        Assert.assertEquals(result, 2);
    }

    public void test3() {
        int result = find.findPairs(new int[]{1, 3, 1, 5, 4}, 0);
        Assert.assertEquals(result, 1);
    }
}
