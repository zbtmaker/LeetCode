package graph;

import java.util.*;

/**
 * 有 N 个网络节点，标记为 1 到 N。
 * 给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
 * 现在，我们向当前的节点 K 发送了一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * https://opendsa-server.cs.vt.edu/ODSA/Books/Everything/html/GraphShortest.html
 * https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/IndexMinPQ.java.html
 * <p>
 * :
 *
 *
 * @author baitao zou
 * date 2020/03/07
 */
public class NetworkDelayTime743 {

    public class Edge {
        int id;
        int dist;

        private Edge(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Edge>> adj = constructWeightedDirectedGraph(times);
        Map<Integer, Integer> queue = new HashMap<>();
        int[] dist = initDist(N, K);
        boolean[] marked = new boolean[N + 1];
        int max = Integer.MIN_VALUE;
        queue.put(K, 0);
        while (!queue.isEmpty()) {
            int minIndex = removeMin(queue);
            marked[minIndex] = true;
            max = Math.max(dist[minIndex], max);
            List<Edge> adjList = adj.get(minIndex);
            if (adjList == null) {
                continue;
            }
            for (Edge tmpEdge : adjList) {
                if (!marked[tmpEdge.id]) {
                    if (dist[tmpEdge.id] > dist[minIndex] + tmpEdge.dist) {
                        dist[tmpEdge.id] = dist[minIndex] + tmpEdge.dist;
                        queue.put(tmpEdge.id, dist[tmpEdge.id]);
                    }
                }

            }
        }
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
        }
        return max;
    }

    /**
     * construct a weighted directed graph
     *
     * @param times
     * @return
     */
    private Map<Integer, List<Edge>> constructWeightedDirectedGraph(int[][] times) {
        Map<Integer, List<Edge>> adj = new HashMap<>();
        List<Edge> list;
        for (int[] time : times) {
            list = (list = adj.get(time[0])) == null ? new LinkedList<>() : list;
            Edge edge = new Edge(time[1], time[2]);
            list.add(edge);
            adj.put(time[0], list);
        }
        return adj;
    }

    private int[] initDist(int N, int K) {
        int[] dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (i == K) {
                dist[i] = 0;
            } else {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        return dist;
    }

    private int removeMin(Map<Integer, Integer> queue) {
        int minDist = Integer.MAX_VALUE;
        int minIndex = 0;
        for (Map.Entry<Integer, Integer> entry : queue.entrySet()) {
            if (minDist > entry.getValue()) {
                minDist = entry.getValue();
                minIndex = entry.getKey();
            }
        }
        queue.remove(minIndex);
        return minIndex;
    }
}
