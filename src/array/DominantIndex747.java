package array;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class DominantIndex747 {

    /**
     * 这个题目转换成找到一个数组中最大数和第二大的数，最后判断第一大的索引是否是
     * 第二大的2倍。
     *
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        int first = nums[0], second = 0, index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (first < nums[i]) {
                second = first;
                first = nums[i];
                index = i;
            } else if (second < nums[i]) {
                second = nums[i];
            }
        }
        return first >= (second << 1) ? index : -1;
    }
}
