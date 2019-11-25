package array;

/**
 * @author Baitao Zou
 * date 2019/07/29
 * 在给定范围内进行与运算
 */
public class rangeBitwiseAnd201 {
    /**
     *
     * @param m 左范围
     * @param n 右范围
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        int result = Integer.MAX_VALUE;
        for (int i = m; i <= n; i++) {
            result = result & i;
        }
        return result;
    }
}
