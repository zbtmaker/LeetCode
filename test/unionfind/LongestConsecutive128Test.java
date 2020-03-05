package unionfind;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/04
 */
public class LongestConsecutive128Test {

    private LongestConsecutive128 longest = new LongestConsecutive128();

    @Test
    public void test() {
        int result = longest.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        Assert.assertEquals(result, 4);
    }

    @Test
    public void test2() {
        int result = longest.longestConsecutive(new int[]{2, 4, 100, 3, 4, 30, 5, 31, 1, 1});
        Assert.assertEquals(result, 7);
    }

    @Test
    public void test3() {
        int result = longest.longestConsecutive(new int[]{5, 4, 100, 1, 4, 30, 3, 5, 2, 31, 1, 1});
        Assert.assertEquals(result, 7);
    }
}
