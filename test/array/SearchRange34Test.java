package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao zou
 * date 2020/12/01
 */
public class SearchRange34Test extends TestCase {
    private SearchRange34 search = new SearchRange34();

    public void test1() {
        int[] result = search.searchRange(new int[]{3, 5, 5, 6, 8, 8, 10}, 8);
        Assert.assertArrayEquals(result, new int[]{4, 5});
    }

    public void test2() {
        int[] result = search.searchRange(new int[]{3, 5, 5, 6, 8, 10}, 8);
        Assert.assertArrayEquals(result, new int[]{4, 4});
    }

    public void test3() {
        int[] result = search.searchRange(new int[]{3, 5, 5, 6, 8, 10}, 7);
        Assert.assertArrayEquals(result, new int[]{-1, -1});
    }

    public void test4() {
        int[] result = search.searchRange(new int[]{1}, 1);
        Assert.assertArrayEquals(result, new int[]{0, 0});
    }

    public void test5() {
        int[] result = search.searchRange(new int[]{1}, 2);
        Assert.assertArrayEquals(result, new int[]{-1, -1});
    }

    public void test6() {
        int[] result = search.searchRange(new int[]{}, 2);
        Assert.assertArrayEquals(result, new int[]{-1, -1});
    }
}
