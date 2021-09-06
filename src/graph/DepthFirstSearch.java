package graph;

import common.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author zoubaitao
 * date 2021/09/06
 */
public class DepthFirstSearch {

    public void dfs(int[][] edges) {
        // 初始化邻接表
        Map<Integer, List<Edge<Integer, Integer>>> adj = CommonUtil.constructWeightedUndirectedGraph(edges);

        // 初始化节点状态
        Map<Integer, Integer> vertexMapColor = CommonUtil.initVertexMapColor(adj);

        // 遍历每一个未经访问的节点
        for (Integer vertex : adj.keySet()) {
            if (CommonConstants.WITHE.equals(vertexMapColor.get(vertex))) {
                dfsVisit(vertex, adj, vertexMapColor);
            }
        }
    }

    private void dfsVisit(Integer curVertex, Map<Integer, List<Edge<Integer, Integer>>> adj,
                          Map<Integer, Integer> vertexMapColor) {

        vertexMapColor.put(curVertex, CommonConstants.GRAY);
        List<Edge<Integer, Integer>> edges = adj.get(curVertex);
        if (CollectionUtils.isEmpty(edges)) {
            vertexMapColor.put(curVertex, CommonConstants.BLACK);
            return;
        }
        for (Edge<Integer, Integer> edge : edges) {
            if (CommonConstants.WITHE.equals(vertexMapColor.get(curVertex))) {
                dfsVisit(edge.des, adj, vertexMapColor);
            }
        }
        vertexMapColor.put(curVertex, CommonConstants.BLACK);
    }
}
