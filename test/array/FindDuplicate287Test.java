package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/09
 */
public class FindDuplicate287Test extends TestCase {

    private final FindDuplicate287 find = new FindDuplicate287();

    public void test1() {
        int result = find.findDuplicate(new int[]{1, 3, 4, 2, 2});
        Assert.assertEquals(result, 2);
    }

    public void test2() {
        int result = find.findDuplicate(new int[]{1, 1});
        Assert.assertEquals(result, 1);
    }

    public void test3() {
        int result = find.findDuplicate(new int[]{3, 1, 3, 4, 2});
        Assert.assertEquals(result, 3);
    }

    public void test4() {
        int result = find.findDuplicate(new int[]{1, 1, 2});
        Assert.assertEquals(result, 1);
    }
}
