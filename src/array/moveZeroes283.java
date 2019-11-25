package array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\17 0017.
 */
public class moveZeroes283 {
    public static void main(String[] args){
        int[] nums = new int[]{11};
        moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums){
        int i = 0;
        int j = nums.length;
        while(i<j){
            if(nums[i] == 0){
                int temp = nums[i];
                int k = i+1;
                for(;k<j;k++){
                    nums[k-1] = nums[k];
                }
                nums[k-1] = temp;
                j--;
            }
            if(nums[i] != 0){
                i++;
            }

        }
    }
    public static void moveZeroes1(int[] nums){
        int point = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[point] = nums[i];
                if(i != point){
                    nums[i] = 0;
                }
                point ++;
            }
        }
    }
}
