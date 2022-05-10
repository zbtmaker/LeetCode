package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/02/25
 */
public class Search81Test extends TestCase {
    private final Search81 search = new Search81();

    public void test1() {
        boolean flag = search.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0);
        Assert.assertTrue(flag);
    }

    public void test2() {
        boolean flag = search.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 6);
        Assert.assertTrue(flag);
    }

    public void test3() {
        boolean flag = search.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 2);
        Assert.assertTrue(flag);
    }

    public void test4() {
        boolean flag = search.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 5);
        Assert.assertTrue(flag);
    }


    public void test5() {
        boolean flag = search.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 1);
        Assert.assertTrue(flag);
    }

    public void test() {
        boolean flag = search.search(new int[]{2, 2, 2, 3, 2, 2, 2}, 3);
        Assert.assertTrue(flag);
    }
}
