package unionfind;

/**
 * @author zoubaitao
 * date 2021/08/29
 */
public class PathCompressionUnionFind extends CommonUnionFind {

    public PathCompressionUnionFind(int num) {
        super(num);
    }

    /**
     * 路径压缩的union算法
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pid = this.root(p);
        int qid = this.root(q);
        if (size[pid] >= size[qid]) {
            id[qid] = pid;
            size[pid] += size[qid];
        } else {
            id[pid] = qid;
            size[qid] += size[pid];
        }
    }


    /**
     * 路径压缩的find Root 方法
     *
     * @param i
     * @return
     */
    public int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}
