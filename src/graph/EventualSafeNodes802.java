package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/03/10
 */
public class EventualSafeNodes802 {
    /**
     * 未访问
     */
    private static final int UNVISITED = 0;

    /**
     * 正在访问中
     */
    private static final int VISITING = 1;

    /**
     * 已经访问过
     */
    private static final int VISITED = 2;


    /**
     * we can use the dfs algorithm to solve this problem.if the adjacent list of the v
     * v can find the eventual status, then the current vertex can find the eventual status.
     * while if there has one vertex in the adjacent list of v can't find the eventual status,
     * the the vertex v can't find the vertex too.
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        LinkedList<Integer> result = new LinkedList<>();
        int[] marked = new int[graph.length];
        boolean[] flag = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (marked[i] == UNVISITED) {
                dfs(i, graph, marked, flag);
            }
        }
        for (int k = 0; k < flag.length; k++) {
            if (flag[k]) {
                result.add(k);
            }
        }
        return result;
    }

    private boolean dfs(int from, int[][] graph, int[] marked, boolean[] flag) {
        int[] adj = graph[from];
        if (adj.length == 0) {
            marked[from] = VISITED;
            flag[from] = true;
            return true;
        }
        marked[from] = VISITING;
        for (int i : adj) {
            if (marked[i] == UNVISITED) {
                if (!dfs(i, graph, marked, flag)) {
                    return false;
                }
            } else if (marked[i] == VISITING) {
                return false;
            } else {
                if (!flag[i]) {
                    return false;
                }
            }
        }
        marked[from] = VISITED;
        flag[from] = true;
        return true;
    }
}
