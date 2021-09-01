package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zoubaitao
 * date 2021/08/29
 */
public class MinCostConnectPoints1584 {

    public int minCostConnectPoints(int[][] points) {
//        return minCostConnectPointsByKruskalAlgo(points);
        return minCostConnectPointsByPrim(points);
    }

    public int minCostConnectPointsByPrim(int[][] points) {
        if(points.length <= 1){
            return 0;
        }
        MinimumSpanningTree tree = new MinimumSpanningTree();
        List<Edge<Integer, Integer>> edges = tree.primAlgo(constructArr(points));
        return edges.stream().mapToInt(Edge::getDis).sum();
    }

    /**
     * @param points 二维平面点集合
     * @return 最小生成树节点距离之和
     */
    private int minCostConnectPointsByKruskalAlgo(int[][] points) {
        MinimumSpanningTree tree = new MinimumSpanningTree();
        List<Edge<Integer, Integer>> edges = tree.kruskalAlgo(constructEdges(points), points.length);
        return edges.stream().mapToInt(Edge::getDis).sum();
    }

    private int[][] constructArr(int[][] points) {
        int len = points.length;
        int[][] edges = new int[len * (len - 1) / 2][3];
        int k = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                edges[k][0] = i;
                edges[k][1] = j;
                edges[k][2] = getDistance(points, i, j);
                k++;
            }
        }
        return edges;
    }

    private List<Edge<Integer, Integer>> constructEdges(int[][] points) {
        List<Edge<Integer, Integer>> edges = new ArrayList<>();
        int len = points.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                edges.add(new Edge<>(i, j, getDistance(points, i, j)));
            }
        }
        return edges;
    }

    private int getDistance(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}
