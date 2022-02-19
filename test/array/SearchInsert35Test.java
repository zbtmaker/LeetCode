package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/19
 */
public class SearchInsert35Test extends TestCase {

    private final SearchInsert35 search = new SearchInsert35();

    public void test1() {
        int result = search.searchInsert(new int[]{1, 3, 5, 6}, 5);
        Assert.assertEquals(result, 2);
    }

    public void test2() {
        int result = search.searchInsert(new int[]{1, 3, 5, 6}, 2);
        Assert.assertEquals(result, 1);
    }

    public void test3() {
        int result = search.searchInsert(new int[]{1, 3, 5, 6}, 0);
        Assert.assertEquals(result, 0);
    }

    public void test4() {
        int result = search.searchInsert(new int[]{1, 3, 5, 6}, 7);
        Assert.assertEquals(result, 4);
    }
}
