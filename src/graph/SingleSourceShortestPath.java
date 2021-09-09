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
     * Dijkstra's Algorithm
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
            Edge<Integer, Integer> minEdge = minQueue.poll();
            for (Edge<Integer, Integer> edge : adj.get(minEdge.src)) {
                Edge<Integer, Integer> disEdge = vertexMapDisEdge.get(edge.des);
                disEdge.dis = Math.min(disEdge.dis, minEdge.dis + edge.dis);
                minQueue.remove(disEdge);
                minQueue.offer(disEdge);
            }
        }
        return vertexMapDisEdge;
    }
}
