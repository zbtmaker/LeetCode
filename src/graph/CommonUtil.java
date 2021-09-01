package graph;

import java.util.*;

/**
 * @author zoubaitao
 * date 2021/08/29
 */
public class CommonUtil {


    /**
     * construct a weighted directed graph
     *
     * @param edges 边集合
     * @return Adjacent List
     */
    public static Map<Integer, List<Edge<Integer, Integer>>> constructWeightedDirectedGraph(int[][] edges) {
        Map<Integer, List<Edge<Integer, Integer>>> adj = new HashMap<>();
        List<Edge<Integer, Integer>> list;
        for (int[] time : edges) {
            list = (list = adj.get(time[0])) == null ? new LinkedList<>() : list;
            Edge<Integer, Integer> edge = new Edge<>(time[1], time[2]);
            list.add(edge);
            adj.put(time[0], list);
        }
        return adj;
    }

    /**
     * @param edges 边结构
     * @return Edge List
     */
    public static List<Edge<Integer, Integer>> constructWeightedEdgeGraph(int[][] edges) {
        List<Edge<Integer, Integer>> weightedEdges = new ArrayList<>(edges.length);
        for (int[] edge : edges) {
            Edge<Integer, Integer> weightedEdge = new Edge<>(edge[0], edge[1], edge[2]);
            weightedEdges.add(weightedEdge);
        }
        return weightedEdges;
    }

    /**
     * 创建一个无向带权重图
     *
     * @param edges 边集合
     * @return Adjacent List
     */
    public static Map<Integer, List<Edge<Integer, Integer>>> constructWeightedUndirectedGraph(int[][] edges) {
        Map<Integer, List<Edge<Integer, Integer>>> adj = new HashMap<>();
        for (int[] edge : edges) {
            List<Edge<Integer, Integer>> list1 = adj.computeIfAbsent(edge[0], k -> new LinkedList<>());
            Edge<Integer, Integer> cur1 = new Edge<>(edge[0], edge[1], edge[2]);
            list1.add(cur1);

            List<Edge<Integer, Integer>> list2 = adj.computeIfAbsent(edge[1], k -> new ArrayList<>());
            Edge<Integer, Integer> cur2 = new Edge<>(edge[1], edge[0], edge[2]);
            list2.add(cur2);
        }
        return adj;
    }
}
