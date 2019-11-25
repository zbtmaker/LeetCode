package array;

/**
 * Created by Administrator on 2019\2\28 0028.
 */
public class jump45 {
    public static void main(String[] args){
        int[] nums = new int[]{2};
        System.out.println(jump(nums));
    }

    /**
     * 时间复杂度为O(N^2),空间复杂度为O(N)，那么我们根本就没有起到
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int[] aux = new int[nums.length];
        for(int i = 1;i<nums.length;i++){
            int min = Integer.MAX_VALUE;
            for(int j = i-1;j>-1;j--){
                if(i - j <= nums[j] && min > aux[j]){
                    min = nums[j];
                }
            }
            aux[i] = min + 1;
        }
        return aux[nums.length-1];
    }
}
