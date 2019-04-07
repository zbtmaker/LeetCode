package Array;

/**
 * Created by Administrator on 2019\1\20 0020.
 */
public class findMaxAverage643 {
    public static void main(String[] args){
        int[] nums = new int[]{1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums,4));
    }
    public static double findMaxAverage(int[] nums,int k){
        int sum = 0;
        int i = 0 ;
        for(;i<k;i++){
            sum += nums[i];
        }
        double max = sum;
        for(;i<nums.length;i++){
            sum = sum + nums[i] - nums[i-k];
            max = sum > max ? sum : max;
        }
        return max/k;
    }
}
