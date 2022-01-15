package array;

/**
 * Created by Administrator on 2019\3\4 0004.
 */
public class MaxSubArray53 {

    /**
     * 我们用一个max记录最大值，用一个sum值来记录当前的和，如果sum<=0,那么我们就不用往后加了，因为继续往后
     * 加的话只会变小，所以我们当sum<=0，那么这个时候我们就从下一个元素进行相加，也就是我们将sum清零。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }

}
