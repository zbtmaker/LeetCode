package graph;

import common.CollectionUtils;

import java.util.*;

/**
 * 图广度优先遍历
 *
 * @author zoubaitao
 * date 2021/09/06
 */
public class BreadthFirstSearch {

    public void bfs(int[][] edges, int start) {
        // 初始化图
        Map<Integer, List<Edge<Integer, Integer>>> adj = CommonUtil.constructWeightedUndirectedGraph(edges);

        // 初始化节点颜色
        Map<Integer, Integer> vertexMapColor = CommonUtil.initVertexMapColor(adj);

        // 初始化各节点的父节点
        Map<Integer, Integer> vertexMapParent = CommonUtil.initVertexMapParent(adj);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        vertexMapColor.put(start, CommonConstants.GRAY);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            List<Edge<Integer, Integer>> edgeList = adj.get(vertex);
            if (CollectionUtils.isNotEmpty(edgeList)) {
                for (Edge<Integer, Integer> edge : edgeList) {
                    vertexMapColor.put(edge.des, CommonConstants.GRAY);
                    vertexMapParent.put(edge.des, vertex);
                    queue.add(edge.des);
                }
            }
            vertexMapColor.put(vertex, CommonConstants.BLACK);
        }
    }
}
