package array;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/06/14
 */
public class FindKthLargest215Test extends TestCase {

    private FindKthLargest215 largest = new FindKthLargest215();

    public void test1() {
        int result = largest.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        Assert.assertEquals(result, 5);
    }

    public void test2() {
        int result = largest.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        Assert.assertEquals(result, 4);
    }
}
