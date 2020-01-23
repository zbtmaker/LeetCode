package array;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class CanPlaceFlowers605 {


    /**
     * 这个题目的问题是要能够种植的花的数量大于给定的n,还是等于n。从最后的结果来看是大于n才可以。
     *
     * @param flowerbed 种花数组
     * @param n         目标数组
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        int len = flowerbed.length;
        while (i < len) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i + 1 < len && flowerbed[i + 1] == 1) {
                i += 3;
            } else if (i - 1 >= 0 && flowerbed[i - 1] == 1) {
                i += 2;
            } else {
                count++;
                if (count == n) {
                    return true;
                }
                i += 2;
            }
        }
        if (count >= n) {
            return true;
        }
        return false;
    }
}
