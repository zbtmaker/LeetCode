package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/01/10
 */
public class BinarySearchTest extends TestCase {
    BinarySearch binarySearch = new BinarySearch();

    public void test1() {
        int index = binarySearch.search(new int[]{1, 2, 3, 4, 5, 6}, 3);
        Assert.assertEquals(index, 2);
    }

    public void test2() {
        int index = binarySearch.search(new int[]{1, 2, 3, 4, 5, 7}, 6);
        Assert.assertEquals(index, -1);
    }

    public void test3() {
        int index = binarySearch.search(new int[]{1, 2, 3, 4, 5, 7}, 5);
        Assert.assertEquals(index, 4);
    }


    public void test4() {
        int index = binarySearch.leftIndexSearch(new int[]{1, 2, 3, 3, 4, 4, 5, 7}, 3);
        Assert.assertEquals(index, 2);
    }

    public void test5() {
        int index = binarySearch.leftIndexSearch(new int[]{1, 2, 3, 3, 4, 4, 5, 7}, 4);
        Assert.assertEquals(index, 4);
    }

    public void test6() {
        int index = binarySearch.rightIndexSearch(new int[]{1, 2, 3, 3, 4, 4, 5, 7}, 4);
        Assert.assertEquals(index, 5);
    }

    public void test7() {
        int index = binarySearch.rightIndexSearch(new int[]{1, 2, 3, 3, 4, 4, 5, 7}, 4);
        Assert.assertEquals(index, 5);
    }
}
