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
            list = adj.computeIfAbsent(time[0], k -> new LinkedList<>());
            Edge<Integer, Integer> edge = new Edge<>(time[0], time[1], time[2]);
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
     * 构造一个无权无向图
     *
     * @param edges 边数组，记录src和des
     * @return 无向图数据结构
     */
    public static Map<Integer, List<Edge<Integer, Integer>>> constructUnionWeightedUndirectedGraph(int[][] edges) {
        Map<Integer, List<Edge<Integer, Integer>>> adj = new HashMap<>();
        List<Edge<Integer, Integer>> srcEdges;
        List<Edge<Integer, Integer>> desEdges;
        for (int[] time : edges) {
            srcEdges = adj.computeIfAbsent(time[0], k -> new LinkedList<>());
            Edge<Integer, Integer> srdEdge = new Edge<>(time[0], time[1], 1);
            srcEdges.add(srdEdge);

            desEdges = adj.computeIfAbsent(time[1], k -> new LinkedList<>());
            Edge<Integer, Integer> desEdge = new Edge<>(time[1], time[0], 1);
            desEdges.add(desEdge);
        }
        return adj;
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


    public static Map<Integer, Integer> initVertexMapColor(Map<Integer, List<Edge<Integer, Integer>>> adj) {
        Map<Integer, Integer> vertexMapColor = new HashMap<>(adj.size());
        for (Integer vertex : adj.keySet()) {
            vertexMapColor.put(vertex, CommonConstants.WITHE);
        }
        return vertexMapColor;
    }


    /**
     * 节点的父节点
     *
     * @param adj 邻接表
     * @return 每一个vertex的parent节点
     */
    public static Map<Integer, Integer> initVertexMapParent(Map<Integer, List<Edge<Integer, Integer>>> adj) {
        Map<Integer, Integer> vertexMapParent = new HashMap<>(adj.size());
        for (Integer vertex : adj.keySet()) {
            vertexMapParent.put(vertex, CommonConstants.NON_PARENT);
        }
        return vertexMapParent;
    }


    /**
     * 每一个节点到source节点的estimate距离（预估节点）
     *
     * @param adj 邻接表
     * @return 每一个vertex的parent节点
     */
    public static Map<Integer, Integer> initVertexMapDistance(Map<Integer, List<Edge<Integer, Integer>>> adj) {
        Map<Integer, Integer> vertexMapParent = new HashMap<>(adj.size());
        for (Integer vertex : adj.keySet()) {
            vertexMapParent.put(vertex, Integer.MAX_VALUE);
        }
        return vertexMapParent;
    }

    /**
     * 通过BFS算法计算从start节点出发到其他每个节点的距离
     *
     * @param graph 邻接矩阵
     * @param start 起始节点
     * @return 从start节点到其他所有节点的距离
     */
    public static Map<Integer, Integer> bfs(Map<Integer, List<Edge<Integer, Integer>>> graph, int start) {
        Map<Integer, Integer> disMap = new HashMap<>();
        disMap.put(start, 0);
        Set<Integer> traverseSet = new HashSet<>(start);
        traverseSet.add(start);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer node = queue.removeFirst();
            List<Edge<Integer, Integer>> edges = graph.get(node);
            if (edges == null) {
                continue;
            }
            for (Edge<Integer, Integer> edge : edges) {
                if (traverseSet.contains(edge.des)) {
                    continue;
                }
                disMap.put(edge.des, disMap.get(edge.src) + 1);
                queue.addLast(edge.des);
                traverseSet.add(edge.des);
            }
        }
        return disMap;
    }
}
