package graph;


/**
 * @author baitao zou
 * date 2020/03/06
 */
public class FindRedundantDirectedConnection685 {

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
        int[] id = initId(edges.length + 1);
        int[][] redundant = new int[2][2];
        redundant[0][0] = -1;
        for (int[] edge : edges) {
            if (union(edge, id, redundant)) {
                if (redundant[0][0] == -1) {
                    return edge;
                } else {
                    return redundant[0];
                }
            }
        }
        return redundant[1];
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
     * @param edge 边 edge[0] -> edge[1]
     * @param id   the index
     * @return
     */
    private boolean union(int[] edge, int[] id, int[][] redundant) {
        int parentId = root(edge[0], id);
        int childId = root(edge[1], id);
        if (childId != edge[1]) {
            redundant[0][0] = childId;
            redundant[0][1] = edge[1];
            redundant[1] = edge;
            return false;
        }
        if (parentId == childId) {
            return true;
        }
        id[childId] = parentId;
        return false;
    }
}
