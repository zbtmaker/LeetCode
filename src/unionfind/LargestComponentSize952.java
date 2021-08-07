package unionfind;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/03/26
 */
public class LargestComponentSize952 {

    public int largestComponentSize(int[] A) {
        return largestComponentSizeByBruteForce(A);
    }

    /**
     * 分解质因数
     *
     * @param a
     * @param countMap
     */

    /**
     * 暴力求解问题
     *
     * @param A
     * @return
     */
    private int largestComponentSizeByBruteForce(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int[] id = initId(len);
        int[] size = new int[len];
        Arrays.fill(size, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int gcd = greatestCommonDivisor(A[i], A[j]);
                if (gcd > 1) {
                    union(i, j, id, size);
                }
            }
        }
        int max = 0;
        for (int i : size) {
            max = Math.max(max, i);
        }
        return max;
    }

    /**
     * 求解数
     *
     * @param i
     * @param id
     * @return
     */
    private int root(int i, int[] id) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    private void union(int p, int q, int[] id, int[] size) {
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
    }

    private int[] initId(int len) {
        int[] id = new int[len];
        for (int i = 0; i < len; i++) {
            id[i] = i;
        }
        return id;
    }

    /**
     * 最大公约数
     *
     * @param a 数a
     * @param b 数b
     * @return 最大公约数
     */
    public int greatestCommonDivisor(int a, int b) {
        if (a == b) {
            return a;
        }
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int res = max - min;
        while (res != min) {
            max = Math.max(min, res);
            min = Math.min(min, res);
            res = max - min;
        }
        return res;
    }
}
