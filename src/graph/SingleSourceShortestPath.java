package graph;

import java.util.*;

/**
 * 有权单源最短路径
 *
 * @author zoubaitao
 * date 2021/09/08
 */
public class SingleSourceShortestPath {

    /**
     * Dijkstra's Algorithm 这个算法适用于有向有权图，对于无向有权图
     * 可以将无向图可以转换成有向图，对于无向无权图，可以采用BFS的方式获取单源最短路径。
     * <p>
     * Input: G is a adjacent list, V is the set of vertex in G,
     * w(u,v) is the distance between vertex u and v, u.d
     * is the estimate distance between source vertex s and u.
     * for each vertex v in G.V.
     * Output: the shortest distance from source vertex to other vertex
     * <p>  v.d = Integer.MAX_VALUE
     * <p>  v.parent = null
     * s.d = 0
     * S = {}
     * Q = G.V
     * while Q ≠ {}
     * <p>  u = EXTRACT-MIN(Q)
     * <p>  S = S+{u}
     * <p>  for each vertex v in G.adj(u)
     * <p>      if v.d > u.d + w(u,v)
     * <p>          v.d = u.d + w(u,v)
     * end
     *
     * @param edges  边的二维数组
     * @param source 源节点
     * @return s到每一个节点的距离
     */
    public Map<Integer, Edge<Integer, Integer>> dijkstra(int[][] edges, int source) {
        Map<Integer, List<Edge<Integer, Integer>>> adj = CommonUtil.constructWeightedDirectedGraph(edges);

        // 初始化节点的预估距离
        Comparator<Edge<Integer, Integer>> comparator = Comparator.comparing(o -> o.dis);
        PriorityQueue<Edge<Integer, Integer>> minQueue = new PriorityQueue<>(comparator);
        Set<Integer> vertexSet = adj.keySet();
        // 存储每个vertex对应在MinQueue中的边，在后面Relax操作采用O(1)时间复杂度
        Map<Integer, Edge<Integer, Integer>> vertexMapDisEdge = new HashMap<>(vertexSet.size());
        for (Integer vertex : adj.keySet()) {
            int distance = Integer.MAX_VALUE;
            if (vertex.equals(source)) {
                distance = 0;
            }
            Edge<Integer, Integer> edge = new Edge<>(vertex, null, distance);
            minQueue.add(edge);
            vertexMapDisEdge.put(vertex, edge);
        }
        while (!minQueue.isEmpty()) {
            // 从最小优先队列中取出距离源节点最近的节点
            Edge<Integer, Integer> minEdge = minQueue.poll();
            for (Edge<Integer, Integer> edge : adj.get(minEdge.src)) {
                Edge<Integer, Integer> disEdge = vertexMapDisEdge.get(edge.des);
                // Relax松弛
                if (disEdge.dis > minEdge.dis + edge.dis) {
                    disEdge.dis = minEdge.dis + edge.dis;
                    minQueue.remove(disEdge);
                    minQueue.offer(disEdge);
                }
            }
        }
        return vertexMapDisEdge;
    }

    public boolean bellmanFord(int[][] edges, int source) {
        List<Edge<Integer, Integer>> adj = CommonUtil.constructWeightedEdgeGraph(edges);
        Set<Integer> vertexSet = new HashSet<>();
        for (Edge<Integer, Integer> edge : adj) {
            vertexSet.add(edge.src);
            vertexSet.add(edge.des);
        }
        Map<Integer, Integer> vertexMapDis = new HashMap<>();
        for (Integer vertex : vertexSet) {
            int dis = Integer.MAX_VALUE;
            if (vertex.equals(source)) {
                dis = 0;
            }
            vertexMapDis.put(vertex, dis);
        }
        for (int i = 0; i < vertexSet.size() - 1; i++) {
            for (Edge<Integer, Integer> edge : adj) {
                long desDis = (long) vertexMapDis.get(edge.des);
                long srcDis = (long) vertexMapDis.get(edge.src);
                if (desDis > srcDis + edge.dis) {
                    vertexMapDis.put(edge.des, (int) srcDis + edge.dis);
                }
            }
        }

        // 判断负权环
        for (Edge<Integer, Integer> edge : adj) {
            long desDis = (long) vertexMapDis.get(edge.des);
            long srcDis = (long) vertexMapDis.get(edge.src);
            if (desDis > srcDis + edge.dis) {
                return false;
            }
        }
        return true;
    }
}
