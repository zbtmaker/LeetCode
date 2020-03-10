package graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author baitao zou
 * date 2020/03/10
 */
public class EventualSafeNodes802Test {

    private EventualSafeNodes802 eventual = new EventualSafeNodes802();

    @Test
    public void test1() {
        List<Integer> result = eventual.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}});
        Assert.assertArrayEquals(result.toArray(new Integer[0]), new Integer[]{2, 4, 5, 6});
    }
}
