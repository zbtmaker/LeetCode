package graph;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Map;

/**
 * @author zoubaitao
 * date 2021/09/10
 */
public class SingleSourceShortestPathTest extends TestCase {
    private final SingleSourceShortestPath shortestPath = new SingleSourceShortestPath();

    public void test1() {
        int[][] edges = new int[][]{{0, 1, 10}, {0, 4, 5},
                {1, 2, 1}, {1, 4, 2},
                {2, 3, 4},
                {3, 2, 6}, {3, 0, 7},
                {4, 1, 3}, {4, 2, 9}, {4, 3, 2}};
        Map<Integer, Edge<Integer, Integer>> vertexMapDis = shortestPath.dijkstra(edges, 0);
        Assert.assertEquals(vertexMapDis.get(0).dis.intValue(), 0);
        Assert.assertEquals(vertexMapDis.get(1).dis.intValue(), 8);
        Assert.assertEquals(vertexMapDis.get(2).dis.intValue(), 9);
        Assert.assertEquals(vertexMapDis.get(3).dis.intValue(), 7);
        Assert.assertEquals(vertexMapDis.get(4).dis.intValue(), 5);
    }
}
