package array;

/**
 * Created by Administrator on 2019\2\28 0028.
 */
public class Jump45 {

    /**
     * 1、动态规划：时间复杂度为O(N^2),空间复杂度为O(N)，那么我们根本就没有起到
     * 2、贪心算法：时间复杂度O(N), 空间复杂度O(1)
     *
     * @param nums 跳跃步数
     * @return 最小跳跃数
     */
    public int jump(int[] nums) {
        return byGreedy(nums);
    }

    private int byDynamicProgramming(int[] nums) {
        int len = nums.length;
        int[] aux = new int[len];
        aux[0] = 0;
        for (int i = 1; i < len; i++) {
            aux[i] = len;
            for (int j = i - 1; j >= 0; j--) {
                if (i - j <= nums[j]) {
                    aux[i] = Math.min(aux[j] + 1, aux[i]);
                }
            }
        }
        return aux[len - 1];
    }

    private int byGreedy(int[] nums) {
        int end = 0, maxPosition = 0, steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
