package array;

/**
 * @author baitao zou
 * date 2020/04/19
 */
public class FindNumberOfLIS673 {
    /**
     * time complexity O(N^2),time complexity O(N).
     *
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        return findNumberOfLISByBruteForce(nums);
    }

    /**
     * 对于最长的递增子序列的个数，那么就是我们对于nums[i]，我们如何找到以nums[i]结束的递增子序列。
     * 那么我们就需要对0...i-1找到比nums[i]小但是能够使子序列长度最长。我们需要一个数组pathNum来记录每一个
     * 位置nums[i]的最长递增子序列数量，用一个数组lenArr来记录最长递增子序列的长度。有了这两个数组来辅助这个
     * 问题就能解决我们面临的问题。
     * 解决算法：Dynamic Programming
     *
     * @param nums
     * @return
     */
    private int findNumberOfLISByBruteForce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] lenArr = new int[len];
        lenArr[0] = 1;
        int[] pathNum = new int[len];
        pathNum[0] = 1;
        int result = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            lenArr[i] = 1;
            pathNum[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (lenArr[i] < lenArr[j] + 1) {
                        lenArr[i] = lenArr[j] + 1;
                        pathNum[i] = pathNum[j];
                    } else if (lenArr[i] == lenArr[j] + 1) {
                        pathNum[i] += pathNum[j];
                    }
                }
            }
            if (lenArr[i] > max) {
                max = lenArr[i];
                result = pathNum[i];
            } else if (lenArr[i] == max) {
                result += pathNum[i];
            }
        }

        return result;
    }

}
