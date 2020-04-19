package array;

/**
 * Created by Administrator on 2019\1\11 0011.
 */
public class FindLengthOfLCIS674 {

    /**
     * 最长连续子序列，对于最长连续子序列，因为每个元素只和其前面的一个元素有关，
     * 对于任意的0 < i < (j= i+1) < nums.length;如果 nums[j] > nums[i].那么这个
     * 时候是连续递增的,因此在前面的基础上直接递增就好了，如果nums[j] < nums[i],那么
     * 这个连续递增的关系就被破坏了,因此应该重新从1来统计最长递增连续子序列。
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                len++;
            } else {
                len = 1;
            }
            max = Math.max(len, max);
        }
        return max;
    }
}
