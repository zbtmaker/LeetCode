package Array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\10 0010.
 */
public class arrayPairSum561 {
    public static void main(String[] args){
        int[] nums = new int[]{1,4,3,2};
        System.out.println(arrayPairSum(nums));
    }
    public static int arrayPairSum(int[] nums){
        int sum = 0;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i += 2){
            sum += nums[i];
        }
        return sum;
    }

}
