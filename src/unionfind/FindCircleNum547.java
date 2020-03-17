package unionfind;

import java.util.Arrays;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * 链接：https://leetcode-cn.com/problems/friend-circles
 *
 * @author baitao zou
 * date 2020/03/17
 */
public class FindCircleNum547 {
    /**
     * 通过Union Find算法来解决这种联通分量问题是最方便的，这个题目和NumIsland200的解题思想是一样的
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int len = M.length;
        int[] id = initId(len);
        int[] cycle = new int[]{len};
        int[] size = new int[len];
        Arrays.fill(size, 1);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (M[i][j] == 1) {
                    union(i, j, id, size, cycle);
                }
            }
        }
        return cycle[0];
    }

    private int root(int i, int[] id) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    private void union(int p, int q, int[] id, int size[], int[] cycle) {
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
        cycle[0] = cycle[0] - 1;
    }

    private int[] initId(int len) {
        int[] id = new int[len];
        for (int i = 0; i < len; i++) {
            id[i] = i;
        }
        return id;
    }
}
