package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zoubaitao
 * date 2021/08/29
 */
public class MinCostConnectPoints1584 {

    public int minCostConnectPoints(int[][] points) {
        MinimumSpanningTree tree = new MinimumSpanningTree();
        List<Edge<Integer, Integer>> edges = tree.kruskalAlgo(construct(points), points.length);
        return edges.stream().mapToInt(Edge::getDis).sum();
    }

    private List<Edge<Integer, Integer>> construct(int[][] points) {
        List<Edge<Integer, Integer>> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(new Edge<>(i, j, getDistance(points, i, j)));
            }
        }
        return edges;
    }

    private int getDistance(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}
