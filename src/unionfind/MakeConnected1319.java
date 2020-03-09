package unionfind;

import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/03/09
 */
public class MakeConnected1319 {

    /**
     * this problem different the NumIslands200, this problem we should record the number of connected component
     * and the number of redundant connection which makes the tree be a cycle.
     * if the number of redundant connection large or equal than the number of connected component minus one, the
     * the minimal connection is the number of connected component minus one, else we should return -1
     *
     * @param n
     * @param connections
     * @return
     */
    public int makeConnected(int n, int[][] connections) {
        int[] id = initId(n);
        int[] size = new int[n];
        Arrays.fill(size, 1);
        int[] component = new int[]{n};
        int[] count = new int[]{0};
        for (int[] connection : connections) {
            union(connection, id, size, component, count);
        }
        if (count[0] >= component[0] - 1) {
            return component[0] - 1;
        }
        return -1;
    }


    private int[] initId(int n) {
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        return id;
    }

    private void union(int[] connection, int[] id, int[] size, int[] component, int[] count) {
        int pid = root(connection[0], id);
        int qid = root(connection[1], id);
        if (pid == qid) {
            count[0] = count[0] + 1;
            return;
        }
        if (size[pid] >= size[qid]) {
            id[qid] = pid;
            size[pid] += size[qid];
        } else {
            id[pid] = qid;
            size[qid] += size[pid];
        }
        component[0] = component[0] - 1;
    }

    private int root(int i, int[] id) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }
}
