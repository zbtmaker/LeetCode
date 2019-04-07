package Array;

/**
 * Created by Administrator on 2019\1\11 0011.
 */
public class findLengthOfLCIS674 {
    public static void main(String[] args){
        //int[] nums = new int[]{1,3,5,4,7};
        //int[] nums = new int[]{2,2,2,2,2};
        int[] nums = new int[]{};
        System.out.println(findLengthOfLCIS(nums));
    }
    public static int findLengthOfLCIS(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int i = 1;
        int length = 1;
        int max = 1;
        while(i<nums.length){
            if(nums[i]>nums[i-1]){
                length++;
                if(max<length){
                    max = length;
                }
            }else{
                length = 1;
            }
            i++;
        }
        return max;
    }
}
