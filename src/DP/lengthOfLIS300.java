package DP;


import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\23 0023.
 */
public class lengthOfLIS300 {
    public static void main(String[] args){
        int[] nums = new int[]{1,10,9,2,5,3,7,101,18};
        //int[] nums = new int[]{1,3,6,7,9,4,10,4,5,6};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int[] aux = new int[nums.length];
        Arrays.fill(aux,1);
        int max = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                aux[i] = aux[i-1]+1;
            }else if(nums[i] == nums[i-1]){
                aux[i] = aux[i-1];
            }else{
                int j = i-2;
                while(j>-1){
                    if(nums[i]>nums[j]){
                        aux[i] = aux[j]+1;
                        break;
                    }else if(nums[i] == nums[j]){
                        aux[i] = aux[j];
                        break;
                    }
                    j--;
                }
            }
            max = max<aux[i]?aux[i]:max;
        }
        return max;
    }
}
