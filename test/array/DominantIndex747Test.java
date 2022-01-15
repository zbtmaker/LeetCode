package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/15
 */
public class DominantIndex747Test extends TestCase {

    private final DominantIndex747 dominant = new DominantIndex747();

    public void test1() {
        int result = dominant.dominantIndex(new int[]{1, 6, 3, 2});
        Assert.assertEquals(result, 1);
    }

    public void test2() {
        int result = dominant.dominantIndex(new int[]{1, 2, 3, 4});
        Assert.assertEquals(result, -1);
    }

    public void test3() {
        int result = dominant.dominantIndex(new int[]{1});
        Assert.assertEquals(result, 0);
    }
}
