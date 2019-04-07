package Array;

/**
 * Created by Administrator on 2019\1\21 0021.
 */
public class minSubArrayLen209 {
    public static void main(String[] args){
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int i = 0;
        for(;i<nums.length;i++){
            sum += nums[i];
            if(sum >= s){
                while(true){
                    sum -= nums[j];
                    if(sum<s){
                        sum += nums[j];
                        break;
                    }
                    j++;
                }
                min = (i-j+1) < min ? (i-j+1):min;
            }

        }
        return min== Integer.MAX_VALUE?0 : min;
        /*
        if(min == Integer.MAX_VALUE){
            return 0;
        }else{
            return min;
        }*/
    }
}
