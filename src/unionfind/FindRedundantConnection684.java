package unionfind;

/**
 * 在本问题中, 树指的是一个连通且无环的无向图。
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 * 链接：https://leetcode-cn.com/problems/redundant-connection
 *
 * @author baitao zou
 * date 2020/03/06
 */
public class FindRedundantConnection684 {


    /**
     * we can use the <union find> algorithm to detect a undirected graph
     * whether has a cycle or not.
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        int[] marked = initMark(edges.length);
        boolean flag;
        for (int[] edge : edges) {
            flag = union(edge[0], edge[1], marked);
            if (flag) {
                return edge;
            }
        }
        return null;
    }

    private int[] initMark(int len) {
        int[] marked = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            marked[i] = i;
        }
        return marked;
    }

    /**
     * union two vertex in the graph, if two vertex has common
     * parent vertex, then the two vertex must has connect before
     * this union, so this edge must be redundant.
     *
     * @param p      first vertex
     * @param q      second vertex
     * @param marked array to record the parent of each vertex in the graph
     * @return true - this edge is redundant | false - not
     */
    private boolean union(int p, int q, int[] marked) {
        int pRoot = parent(p, marked);
        int qRoot = parent(q, marked);
        if (pRoot == qRoot) {
            return true;
        }
        marked[qRoot] = pRoot;
        return false;
    }

    /**
     * find the parent vertex of current vertex
     *
     * @param vertex a vertex in the graph
     * @param marked to record the parent of each vertex
     * @return the parent vertex of current vertex
     */
    private int parent(int vertex, int[] marked) {
        while (vertex != marked[vertex]) {
            vertex = marked[vertex];
        }
        return vertex;
    }
}
