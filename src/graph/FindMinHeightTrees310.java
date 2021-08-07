package graph;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/11/22
 */
public class FindMinHeightTrees310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        return findMinHeightTreesByBFS(n, edges);
    }

    /**
     * 找到最小高度数，采用BFS的方式
     *
     * @param n     节点数
     * @param edges 图边数
     * @return 最小高度树的根节点
     */
    private List<Integer> findMinHeightTreesByBFS(int n, int[][] edges) {
        List<List<Integer>> graph = constructGraph(n, edges);
        List<Integer> minNodes = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int maxDepth = maxDepth(n, i, graph);
            if (maxDepth < min) {
                minNodes = new LinkedList<>();
                minNodes.add(i);
                min = maxDepth;
            } else if (maxDepth == min) {
                minNodes.add(i);
            }
        }

        return minNodes;
    }

    /**
     * @param n     节点数
     * @param graph 邻接链表
     */
    private int maxDepth(int n, int root, List<List<Integer>> graph) {
        boolean[] flag = new boolean[n];
        Stack<Integer> queue1 = new Stack<>();
        Stack<Integer> queue2 = new Stack<>();
        queue1.push(root);
        flag[root] = true;
        int count = 0;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue1.isEmpty()) {
                while (!queue2.isEmpty()) {
                    queue1.push(queue2.pop());
                }
            }
            while (!queue1.isEmpty()) {
                List<Integer> list = graph.get(queue1.pop());
                for (Integer node : list) {
                    if (!flag[node]) {
                        queue2.push(node);
                        flag[node] = true;
                    }
                }
            }
            count++;
        }
        return count;
    }

    /**
     * 根据边构造邻接表
     *
     * @param n     节点数
     * @param edges 边
     * @return 邻接矩阵
     */
    private List<List<Integer>> constructGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    private List<Integer> findMinHeightTreesByTopological(int n, int[][] edges) {
        int[] inDegreeArr = new int[n];
        for (int[] edge : edges) {
            inDegreeArr[edge[0]]++;
            inDegreeArr[edge[1]]++;
        }
        List<List<Integer>> graph = constructGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegreeArr[i] == 1) {
                queue.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        return result;
    }
}
