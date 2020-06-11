package array;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/06/04
 */
public class TopKFrequent347Test extends TestCase {

    private TopKFrequent347 top = new TopKFrequent347();

    public void test1() {
        int[] arr = top.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        Assert.assertArrayEquals(arr, new int[]{1, 2});
    }

    public void test2() {
        int[] arr = top.topKFrequent(new int[]{1}, 1);
        Assert.assertArrayEquals(arr, new int[]{1});

    }
}
