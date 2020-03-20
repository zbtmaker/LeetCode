package graph;


/**
 * @author baitao zou
 * date 2020/03/06
 */
public class FindRedundantDirectedConnection685 {

    private static final int UNCYCLE = 0;

    private static final int CYCLE = 1;

    private static final int DUPLICATE = 2;

    /**
     * The Breadth first search can't solve this problem.
     * From the description of this we can know ,every
     * node must just has one parent. If one node has
     * two parent, the there must have one
     *
     * @param edges
     * @return
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] id = initId(edges.length);
        int[] marked = new int[2];
        for (int[] edge : edges) {
            if (union(edge[0], edge[1], id)) {
                return edge;
            }
        }
        return marked;
    }

    private int[] initId(int len) {
        int[] id = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            id[i] = i;
        }
        return id;
    }

    private int root(int i, int[] id) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    /**
     * @param p  the parent vertex
     * @param c  the child vertex
     * @param id the index
     * @return
     */
    private boolean union(int p, int c, int[] id) {
        int pRoot = root(p, id);
        int cRoot = root(c, id);
        if (pRoot == cRoot) {
            return true;
        }
        if (cRoot != c) {
            return false;
        }
        id[cRoot] = pRoot;
        return false;
    }
}
