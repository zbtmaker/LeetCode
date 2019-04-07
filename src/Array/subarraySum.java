package Array;

/**
 * Created by Administrator on 2019\1\21 0021.
 */
public class subarraySum {
    public static void main(String[] args){
        int[] nums = new int[]{1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums,k));

    }
    public static int subarraySum(int[] nums, int k) {
        int j = 0;
        int sum = 0;
        int count = 0;

        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            while(sum > k){
                sum -= nums[j];
                j++;
            }
            if(sum == k){
                count ++;
                sum -= nums[j];
                j++;
            }

        }

        return count;
    }
}
