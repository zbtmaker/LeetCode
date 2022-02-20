package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/20
 */
public class LargestNumber179Test extends TestCase {

    private final LargestNumber179 largest = new LargestNumber179();

    public void test1() {
        String result = largest.largestNumber(new int[]{10, 2});
        Assert.assertEquals(result, "210");
    }

    public void test2() {
        String result = largest.largestNumber(new int[]{3, 30, 34, 5, 9});
        Assert.assertEquals(result, "9534330");
    }

    public void test3() {
        String result = largest.largestNumber(new int[]{432, 43243});
        Assert.assertEquals(result, "43243432");
    }

    public void test4() {
        Assert.assertEquals(largest.compareTo("432", "43243"), 1);
    }

    public void test5() {
        Assert.assertEquals(largest.compareTo("43243", "432"), -1);
    }
}
