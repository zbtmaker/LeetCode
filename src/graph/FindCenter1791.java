package graph;

/**
 * @author zoubaitao
 * date 2022/02/18
 */
public class FindCenter1791 {
    public int findCenter(int[][] edges) {
        return byCompare(edges);
    }


    /**
     * 通过统计每个节点的度的方式，节点度>1的节点就是中心节点。
     * 下面的做法看似对edges数组做了循环统计后得出结果，实际上
     * 通过统计前两条边就能得出最终的center节点。
     *
     * @param edges 边集合
     * @return center
     */
    private int byCountArr(int[][] edges) {
        int[] count = new int[edges.length + 1];
        for (int[] edge : edges) {

            count[edge[0] - 1]++;
            count[edge[1] - 1]++;
            if (count[edge[0] - 1] > 1) {
                return edge[0];
            }
            if (count[edge[1] - 1] > 1) {
                return edge[1];
            }
        }
        return 0;
    }

    private int byCompare(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        if (edges[0][1] == edges[1][0] || edges[0][1] == edges[1][1]) {
            return edges[0][1];
        }
        return -1;
    }
}
