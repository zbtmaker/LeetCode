package unionfind;

/**
 * @author baitao zou
 * date 2020/04/01
 */
public class WeightedUnionFind extends CommonUnionFind {
    protected int group;

    public WeightedUnionFind(int num) {
        super(num);
        group = num;
    }

    public void union(int p, int q) {
        int pid = this.root(p);
        int qid = this.root(q);
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
