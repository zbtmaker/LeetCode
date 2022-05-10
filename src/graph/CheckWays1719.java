package graph;

import java.util.*;

/**
 * @author zoubaitao
 * date 2022/02/16
 */
public class CheckWays1719 {

    /**
     * 这里用深度优先遍历，在遍历的过程中需要记录路径上所有的节点，
     * 1、如果想要构成一棵树，那么就需要其中一个节点相邻的节点数量是总节点数量，这样才能构成一个树
     * 2、如果一个节点可以选择的节点大于1，那么可以构造二叉树或者链表的形式，所以有三种构造方式。
     *
     * @param pairs 父子节点集合
     * @return 0-无法构成树 ｜ 1-可以构成树 ｜ 2-可以构成多棵树
     */
    public int checkWays(int[][] pairs) {
        return byDfs(pairs);
    }

    public int byLeetcode(int[][] pairs) {
        // 1. 根节点肯定是跟所有节点都有关联的
        // 2. 一个节点相关的pair数量肯定小于或等于其父节点相关的pair数量，且是其父的相关pair的子集
        // 3. 如果是相等的话，肯定不止一种构造树的方式，因为他们可以交换一下位置
        // 4. 我们需要遍历所有的节点看它是否都满足上面的条件2和条件3
        // 开始撸代码~~

        // 使用Map存储每个节点的对应关系
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.computeIfAbsent(pair[0], k -> new HashSet<>()).add(pair[1]);
            map.computeIfAbsent(pair[1], k -> new HashSet<>()).add(pair[0]);
        }

        // 找到任意一个根节点
        Integer root = findRoot(map);
        if (root == null) {
            return 0;
        }

        // 遍历所有节点（除根节点），看是否满足条件2和条件3
        int ans = 1;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int node = entry.getKey();
            // 根节点是没有父节点的，所以不用参与计算
            if (node == root) {
                continue;
            }

            // 寻找父节点
            Integer parent = findParent(map, node);
            if (parent == null) {
                return 0;
            }

            // 检查当前节点的pair是否为父节点的pair的子集
            Set<Integer> parentSet = map.get(parent);
            Set<Integer> currentSet = entry.getValue();
            if (!containsAll(parent, parentSet, currentSet)) {
                return 0;
            }

            // 如果与父节点的pair数量相等，说明可交换，那就不止一棵树了
            if (currentSet.size() == parentSet.size()) {
                ans = 2;
            }
        }

        return ans;
    }

    private Integer findRoot(Map<Integer, Set<Integer>> map) {
        // 总节点数
        int size = map.size();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == size - 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    private Integer findParent(Map<Integer, Set<Integer>> map, int node) {
        int currentSize = map.get(node).size();
        Integer parent = null;
        int parentSize = Integer.MAX_VALUE;
        for (int related : map.get(node)) {
            int relatedSize = map.get(related).size();
            // 关联数 “略大于” 当前节点的节点才是父节点，其他的是祖先节点
            if (node != related && relatedSize >= currentSize && relatedSize < parentSize) {
                parent = related;
                parentSize = relatedSize;
            }
        }
        return parent;
    }

    private boolean containsAll(int parent, Set<Integer> parentSet, Set<Integer> currentSet) {
        for (int current : currentSet) {
            if (current != parent && !parentSet.contains(current)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param pairs
     * @return
     */
    private int byDfs(int[][] pairs) {
        Map<Integer, Set<Integer>> graph = constructGraph(pairs);
        Set<Integer> nodeSet = graph.keySet();
        int count = 0;
        Set<Integer> pathNodeSet = new HashSet<>();
        for (Integer node : nodeSet) {
            if (graph.get(node).size() != graph.size() - 1) {
                continue;
            }
            pathNodeSet.add(node);
            Set<Integer> traversedSet = new HashSet<>(graph.size());
            traversedSet.add(node);
            dfs(graph, node, traversedSet, pathNodeSet);
            pathNodeSet.remove(node);
            if (traversedSet.size() == graph.size()) {
                count++;
            }
        }
        return count > 1 ? 2 : count;
    }

    /**
     * 构建一个无权双向图
     *
     * @param edges 边
     * @return 图
     */
    private Map<Integer, Set<Integer>> constructGraph(int[][] edges) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int src = edge[0], des = edge[1];
            Set<Integer> srcSet = adj.computeIfAbsent(src, k -> new HashSet<>());
            srcSet.add(des);
            Set<Integer> desSet = adj.computeIfAbsent(des, k -> new HashSet<>());
            desSet.add(src);
        }
        return adj;
    }

    private void dfs(Map<Integer, Set<Integer>> graph, Integer curNode, Set<Integer> traversedSet,
                     Set<Integer> pathNodeSet) {
        Set<Integer> desSet = graph.get(curNode);
        for (Integer des : desSet) {
            traversedSet.add(des);
            if (traversedSet.contains(des) || !desSet.containsAll(pathNodeSet)) {
                continue;
            }
            pathNodeSet.add(des);
            dfs(graph, des, traversedSet, pathNodeSet);
            pathNodeSet.remove(des);
        }
    }


}