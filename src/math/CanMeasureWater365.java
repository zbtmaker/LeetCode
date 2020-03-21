package math;

/**
 * @author baitao zou
 * date 2020/03/21
 */
public class CanMeasureWater365 {
    /**
     * 这个算法使用数学公式来解决问题
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }

        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        return z % greatestCommonDivisor(max, min) == 0;
    }

    /**
     * 最大公约数算法
     *
     * @param max
     * @param min
     * @return
     */
    private int greatestCommonDivisor(int max, int min) {
        if (min == max) {
            return min;
        }
        int res = max - min;
        while (res != min) {
            max = Math.max(res, min);
            min = Math.min(res, min);
            res = max - min;
        }
        return res;
    }
}
