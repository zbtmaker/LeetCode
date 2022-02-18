package graph;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/18
 */
public class FindCenter1791Test extends TestCase {

    private final FindCenter1791 findCenter = new FindCenter1791();

    public void test1() {
        int center = findCenter.findCenter(new int[][]{
                {1, 2}, {2, 3}, {4, 2}
        });
        Assert.assertEquals(center, 2);
    }

    public void test2() {
        int center = findCenter.findCenter(new int[][]{
                {1, 2}, {5, 1}, {1, 3}, {1, 4}
        });
        Assert.assertEquals(center, 1);
    }
}
