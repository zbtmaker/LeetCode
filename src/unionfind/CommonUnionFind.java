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
public class CommonUnionFind {
    protected final int[] id;

    protected final int[] size;



    public CommonUnionFind(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("the length must bigger than zero");
        }
        id = new int[num];
        for (int i = 0; i < num; i++) {
            id[i] = i;
        }
        size = new int[num];
        Arrays.fill(size, 1);
    }

    public int root(int i) {
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
}
