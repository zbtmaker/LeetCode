package unionfind;

/**
 * @author baitao zou
 * date 2020/04/01
 */
public class WeightedUnionFind {
    /**
     * the parent of each id
     */
    private int[] id;

    /**
     * the size of each the union tree
     */
    private int[] size;

    private int group;

    public WeightedUnionFind(int len) {
        if (len <= 0) {
            throw new IllegalArgumentException("the length must bigger than zero");
        }
        group = len;
        id = new int[len];
        size = new int[len];
        for (int i = 0; i < len; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i, int[] id) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int pid = root(p, id);
        int qid = root(q, id);
        if (pid == qid) {
            return;
        }
        if (size[pid] > size[qid]) {
            id[qid] = pid;
            size[pid] += size[qid];
        } else {
            id[pid] = qid;
            size[qid] += size[pid];
        }
        group--;
    }

    public int getGroup() {
        return this.group;
    }
}
