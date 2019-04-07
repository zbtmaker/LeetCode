package Array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\2\27 0027.
 */
public class searchRange34 {
    public static void main(String[] args){
        int[] nums = new int[]{5,7,7,8,10};
        System.out.println(Arrays.toString(searchRange(nums,8)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] index = new int[2];
        Arrays.fill(index,-1);
        int i = 0;
        while(i<nums.length){
            if(nums[i] == target){
                index[0] = i;
                i++;
                while(i<nums.length && nums[i] == target){
                    i++;
                }
                index[1] = i-1;
            }else{
                i++;
            }
        }
        return index;
    }
}
