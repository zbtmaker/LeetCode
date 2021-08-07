package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/02/25
 */
public class TestSearch81 extends TestCase {
    Search81 search = new Search81();

    public void test1() {
        boolean flag = search.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0);
        Assert.assertTrue(flag);
    }
}
