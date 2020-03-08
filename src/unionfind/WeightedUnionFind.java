package unionfind;

import java.util.Arrays;

/**
 * Weighted Union Find Algorithm
 * https://opendsa-server.cs.vt.edu/ODSA/Books/Everything/html/UnionFind.html#the-union-find-problem
 * two dimension array : https://stackoverflow.com/questions/49084312/union-find-in-a-2d-array-java
 *
 * @author baitao zou
 * date 2020/03/08
 */
public class WeightedUnionFind {
    private int[] id;

    private int[] size;

    public WeightedUnionFind(int num) {
        id = new int[num];
        for (int i = 0; i < num; i++) {
            id[i] = i;
        }
        size = new int[num];
        Arrays.fill(size, 1);
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        id[qid] = pid;
    }

    /**
     * 带权重的union算法
     *
     * @param p
     * @param q
     */
    public void weightedUnion(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        if (size[pid] >= size[qid]) {
            id[qid] = pid;
            size[pid] += size[qid];
        } else {
            id[pid] = qid;
            size[qid] += size[pid];
        }
    }

    /**
     * 路径压缩的union算法
     *
     * @param p
     * @param q
     */
    public void pathCompressionUnion(int p, int q) {
        int pid = pathCompressionRoot(p);
        int qid = pathCompressionRoot(q);
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
    private int pathCompressionRoot(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}
