package graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author baitao zou
 * date 2020/03/07
 */
public class NetworkDelayTime743Test {
    private NetworkDelayTime743 delay = new NetworkDelayTime743();

    @Test
    public void test1() {
        int[][] times = new int[][]{{1, 2, 5}, {1, 5, 10}, {2, 3, 2}, {2, 4, 9}, {2, 5, 3}, {3, 1, 7}, {3, 4, 6}, {4, 3, 4}, {5, 4, 1}, {5, 2, 2}};
        int result = delay.networkDelayTime(times, 5, 1);
        Assert.assertEquals(result, 9);
    }

    @Test
    public void test2() {
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int result = delay.networkDelayTime(times, 4, 2);
        Assert.assertEquals(result, 2);
    }

    @Test
    public void test3() {
        int[][] times = new int[][]{{2, 4, 10}, {5, 2, 38}, {3, 4, 33}, {4, 2, 76}, {3, 2, 64}, {1, 5, 54}, {1, 4, 98}, {2, 3, 61}, {2, 1, 0}, {3, 5, 77}, {5, 1, 34}, {3, 1, 79}, {5, 3, 2}, {1, 2, 59}, {4, 3, 46}, {5, 4, 44}, {2, 5, 89}, {4, 5, 21}, {1, 3, 86}, {4, 1, 95}};
        int result = delay.networkDelayTime(times, 5, 1);
        Assert.assertEquals(result, 69);
    }
}