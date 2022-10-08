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
        return jumpPointer(nums);
    }

    /**
     * time complexity O(N^2)
     * space complexity O(N)
     * @param nums 跳跃数组
     */
    private int jumpWithMemo(int[] nums){
        int len = nums.length;
        if(len <= 1) {
            return 0;
        }
        int[] F = new int[len];
        for(int i = 1; i < len; i++) {
            int min = Integer.MAX_VALUE;
            for(int j =  i - 1; j >= 0; j--) {
                if(i - j <= nums[j]) {
                    min = Math.min(min, F[j] + 1);
                }
            }
            F[i] = min;
        }
        return F[len-1];
    }

    /**
     * 在原来跳跃游戏的双指针问题上，采用一个额外的数组将前面求解的问题
     * 如果left + nums[left] > right ，那么表明边界扩张了。而扩张的
     * 范围是[right + 1, left + nums[left]]内的数据需要重新计算跳跃的
     * 次数。同时也需要更新right智者。
     */
    private int jumpPointer(int[] nums) {
        int len = nums.length;
        if(len <= 1) {
            return 0;
        }
        int left =0, right = 0;
        int[] F = new int[len];
        while(left <=right && left < len) {
            if(left + nums[left] > right) {
                int k = right + 1;
                while(k <= left + nums[left] && k < len) {
                    F[k++] = F[left] + 1;
                }
                right = left + nums[left];
            }
            left ++;
        }
        return F[len - 1];
    }
}
