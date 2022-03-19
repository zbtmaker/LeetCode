package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zoubaitao
 * date 2022/03/11
 */
public class CountHighestScoreNodes2049 {

    /**
     * 1、计算每个节点的子树
     * 2、每个节点只要计算其每个child 子树有多少个节点即可
     * 3、再依次计算每个节点的得分即可
     * 4、这里还需要注意的一点就是我们的每一个节点的得分是超出Integer.MAX_VALUE值的，要用long类型记录数据
     *
     * @param parents 每一个节点的父节点
     * @return 最高得分的节点数
     */
    public int countHighestScoreNodes(int[] parents) {
        int len = parents.length;
        Map<Integer, List<Integer>> graph = constructGraph(parents);
        int[] nodeCount = new int[len];
        dfs(0, graph, nodeCount);
        long max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < len; i++) {
            List<Integer> children = graph.get(i);
            if (children == null) {
                if (len - 1 > max) {
                    max = len - 1;
                    count = 1;
                } else if (len - 1 == max) {
                    count++;
                }
            } else {
                long mul = 1;
                for (int child : children) {
                    mul *= nodeCount[child];
                }
                // 如果父节点不是0，那么节点将会是与三个节点相连
                if (parents[i] != -1) {
                    mul *= (len - nodeCount[i]);
                }
                if (mul > max) {
                    count = 1;
                    max = mul;
                } else if (mul == max) {
                    count++;
                }
            }
        }
        return count;
    }

    private int dfs(int curNode, Map<Integer, List<Integer>> graph, int[] nodeCount) {
        List<Integer> children = graph.get(curNode);
        if (children == null) {
            nodeCount[curNode] = 1;
            return 1;
        }
        int sum = 1;
        for (Integer child : children) {
            sum += dfs(child, graph, nodeCount);
        }
        nodeCount[curNode] = sum;
        return sum;
    }

    private Map<Integer, List<Integer>> constructGraph(int[] parents) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            int parent = parents[i];
            if (parent == -1) {
                continue;
            }
            List<Integer> children = graph.computeIfAbsent(parent, k -> new ArrayList<>());
            children.add(i);
        }
        return graph;
    }
}
