package array;

/**
 * @author Baitao Zou
 * date 2019/07/29
 * 在给定范围内进行与运算
 */
public class RangeBitwiseAnd201 {
    /**
     * @param left  左范围
     * @param right 右范围
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return left;
        }
        int result = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            result = result & i;
        }
        return result;
    }
}
