package graph;

import java.util.*;

/**
 * @author zoubaitao
 * date 2022/03/20
 */
public class NetworkBecomesIdle2039 {

    /**
     * 1、构建一张无向图
     * 2、计算节点0到达每一个节点最短的距离
     * 3、计算最短距离和patience数组之间的关系，依次计算每个节点的最大往返传输时间，取所有节点的最大值
     * 我们用minDis[i]表示节点的最短距离，如果patience[i] >= dis[i]，那么此时该节点就不会发送第二次
     * 确认消息，该节点的空闲值为2*dis[i] + 1，如果patience[i] < 2*dis[i]，这个时候就需要通过归纳得出
     * 一个公式了。节点i的往返时间为2*minDis[i]，计算节点i节点中第一次发出信息到回到原点后，最后一次发出消
     * 息的还剩几秒能够到达终点剩余的时间就是当前节点的空闲时间。
     * 时间复杂度O（N）, 空间复杂度O(M*N)。
     *
     * @param edges    边
     * @param patience 最长等待时间
     * @return 空闲时刻
     */
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        // 构建无向无权图
        Map<Integer, List<Edge<Integer, Integer>>> graph = CommonUtil.constructUnionWeightedUndirectedGraph(edges);

        // 计算从0节点到其他节点的距离
        Map<Integer, Integer> disMap = CommonUtil.bfs(graph, 0);
        int[] disArr = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            disArr[i] = disMap.get(i);
        }
        System.out.println(Arrays.toString(disArr));
        int max = Integer.MIN_VALUE;
        for (int node = 1; node < graph.size(); node++) {
            int dis = disMap.get(node) * 2;
            int idle;
            if (patience[node] >= dis) {
                idle = dis;
            } else {
                int mod = dis % patience[node];
                if (mod == 0) {
                    idle = dis + (dis - patience[node]);
                } else {
                    idle = dis + (dis - mod);
                }
            }
            max = Math.max(idle, max);
        }
        return max + 1;
    }
}
