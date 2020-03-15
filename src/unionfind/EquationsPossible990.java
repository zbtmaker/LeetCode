package unionfind;

import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/03/11
 */
public class EquationsPossible990 {

    private static final int NUM = 26;

    private static final String EQUAL = "==";

    /**
     * 第一遍扫描整个数组，将所有"=="的字母连接起来连方程中所有等式==
     * 第二遍扫描整个数组，如果不等式中出现root(p) == root(q)，则返回false
     *
     * @param equations 等式
     * @return true-合法等式集合 ｜ false-非法等式
     */
    public boolean equationsPossible(String[] equations) {
        int[] id = initId();
        int[] size = new int[NUM];
        Arrays.fill(size, 1);

        for (String equation : equations) {
            if (EQUAL.equals(equation.substring(1, 3))) {
                union(equation.charAt(0) - 'a', equation.charAt(3) - 'a', id, size);
            }
        }

        for (String equation : equations) {
            if (!EQUAL.equals(equation.substring(1, 3))) {
                int pid = root(equation.charAt(0) - 'a', id);
                int qid = root(equation.charAt(3) - 'a', id);
                if (pid == qid) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 连接节点p和q
     *
     * @param p  第一个节点
     * @param q  第二个节点
     * @param id 父节点数组
     */
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

    /**
     * 寻找一个节点的父节点
     *
     * @param i  当前节点
     * @param id 父节点数组
     * @return 父节点
     */
    private int root(int i, int[] id) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    /**
     * @return 父节点记录数组
     */
    private int[] initId() {
        int[] id = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            id[i] = i;
        }
        return id;
    }
}
