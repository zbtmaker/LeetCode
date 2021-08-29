package graph;

import unionfind.CommonUnionFind;

import java.util.*;

/**
 * @author zoubaitao
 * date 2021/08/29
 */
public class MinimumSpanningTree {

    public int kruskal(int[][] edges) {
        // 初始化图
        List<Edge<Integer, Integer>> weightedEdges = CommonUtil.constructWeightedEdgeGraph(edges);
        Set<Integer> set = new HashSet<>();
        for (int[] edge : edges) {
            set.add(edge[0]);
            set.add(edge[1]);
        }
        List<Edge<Integer, Integer>> result = kruskalAlgo(weightedEdges, set.size());
        return result.stream().mapToInt(Edge::getDis).sum();
    }

    /**
     * Kruskal算法 Pseudocode
     * Input: The edge of the graph e, where each element in e is (u, v, w) denoting
     * that there is an edge between u and v weighted w.
     * Output: The edge of the MST of the input graph.
     * Method:
     * result <- new ArrayList.
     * sort e into non-decreasing order by weight w.
     * for each edge(u, v, w) in the sorted e
     * <p>if u and v are not connected in the union-find set
     * <p>     connect u and v in the union-find set
     * <p>     result = result.add(edge)
     * return result.
     */
    public List<Edge<Integer, Integer>> kruskalAlgo(List<Edge<Integer, Integer>> weightedEdges, int nodeSize) {
        // 按照边的weight从小到大排序
        weightedEdges.sort(Comparator.comparingInt(o -> o.dis));

        //初始化并查集
        CommonUnionFind unionFind = new CommonUnionFind(nodeSize);

        List<Edge<Integer, Integer>> result = new ArrayList<>();
        for (Edge<Integer, Integer> edge : weightedEdges) {
            int srcRoot = unionFind.root(edge.src);
            int desRoot = unionFind.root(edge.des);
            // 判断两个节点是否已经在并查集中连接节点
            if (srcRoot != desRoot) {
                unionFind.union(srcRoot, desRoot);
                result.add(edge);
            }
        }
        return result;
    }


    /**
     * Prime算法 Pseudocode
     * Input: The nodes of the graph V; the function g(u,v) which means the weight
     * <p>    of the edge (u, v); the function adj(v) which means the nodes adjacent
     * <p>    to v
     * Output: The sum of weights of the MST of the input graph.
     * Method:
     * result <- new ArrayList();
     * choose an arbitrary node in V to be the root;
     * dis(root) <- 0
     * for each node v initial V\{root}
     * <p>  dis(v) <- ∞
     * rest <- V
     * while result ≠ ø
     * <p>  cur <- the node with minimum dis in rest
     * <p>  result <- result + dis(cur)
     * <p>  rest <- result\{cur}
     * <p>  for each node v in adj(cur)
     * <p>      dis(v) <- min{dis(v), g(cur,v)}
     * return result.
     *
     * @param edges
     * @return
     */

    public int prime(int[][] edges) {
        Map<Integer, List<Edge<Integer, Integer>>> adj = CommonUtil.constructWeightedUndirectedGraph(edges);

        int result = 0;

        // 初始化每一个节点的dis关系
        Iterator<Integer> iterator = adj.keySet().iterator();
        int root = iterator.next();
        Map<Integer, Edge<Integer, Integer>> srcMapEdge = new HashMap<>();
        PriorityQueue<Edge<Integer, Integer>> queue = new PriorityQueue<>();
        Edge<Integer, Integer> edge = new Edge<>(root, Integer.MAX_VALUE);
        queue.add(edge);
        srcMapEdge.put(root, edge);
        while (iterator.hasNext()) {
            root = iterator.next();
            edge = new Edge<>(root, Integer.MAX_VALUE);
            queue.add(edge);
            srcMapEdge.put(root, edge);
        }

        while (!queue.isEmpty()) {
            Edge<Integer, Integer> minNode = queue.poll();
            result += minNode.dis;
            for (Edge<Integer, Integer> cur : adj.get(minNode.des)) {
                Edge<Integer, Integer> disNode = srcMapEdge.get(cur.des);
                disNode.dis = Math.min(disNode.dis, cur.dis);
            }
        }
        return result;
    }
}
