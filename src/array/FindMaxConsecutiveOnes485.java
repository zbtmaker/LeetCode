package array;

/**
 * Created by Administrator on 2019\1\16 0016.
 */
public class FindMaxConsecutiveOnes485 {
    /**
     * 这个题目有个很好的点就是一旦当nums[i] 等于零时，开始计算最大连续1的个数，
     * 这种计算方式的好处是当测试用例中1较多的情况下会减少Math.max()方法的调用。
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int num : nums) {
            if (num == 0) {
                max = Math.max(max, count);
                count = 0;
            } else {
                count++;
            }
        }
        return Math.max(max, count);
    }

}
