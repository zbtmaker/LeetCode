package graph;


import java.util.*;

/**
 * @author baitao zou
 * date 2020/03/06
 */
public class FindRedundantDirectedConnection685 {

    /**
     * Breadth first search can solve this problem.
     *
     * @param edges
     * @return
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        Map<Integer, List<Integer>> adj = constructAdj(edges);
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] marked = new boolean[edges.length + 1];
        // analysis the reachability
        for (int[] edge : edges) {
            boolean flag = reach(edge[0], adj, edges.length);
            System.out.println(flag);
        }
        return null;
    }

    /**
     * construct a adjacent list
     *
     * @param edges
     * @return
     */
    private Map<Integer, List<Integer>> constructAdj(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new HashMap<>();
        }
        int len = edges.length;

        Map<Integer, List<Integer>> adj = new HashMap<>(len);
        List<Integer> list;
        for (int[] edge : edges) {
            list = (list = adj.get(edge[0])) == null ? new LinkedList<>() : list;
            list.add(edge[1]);
            adj.put(edge[0], list);
        }
        return adj;
    }

    /**
     * the start vertex can reach every vertex in the graph or not
     *
     * @param start
     * @return
     */
    private boolean reach(int start, Map<Integer, List<Integer>> adj, int len) {
        boolean[] marked = new boolean[len + 1];
        int num = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        marked[start] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            List<Integer> adjList = adj.get(vertex);
            if (adjList == null) {
                marked[vertex] = true;
                continue;
            }
            for (int tmpVertex : adjList) {
                if (!marked[tmpVertex]) {
                    queue.add(tmpVertex);
                    num++;
                    marked[tmpVertex] = true;
                }
            }
        }
        if (num == len) {
            return true;
        }
        return false;
    }
}
