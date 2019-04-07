package Array;

/**
 * Created by Administrator on 2019\1\16 0016.
 */
public class isMonotonic896 {
    public static void main(String[] args){
        int[] nums = new int[]{1,3,1,2};
        System.out.println(isMonotonic(nums));
    }
    public static boolean isMonotonic(int[] nums){
        if(nums.length<=1){
            return true;
        }
        int i = 1;
        while(i<nums.length){
            while(nums[i] == nums[i-1]){
                i++;
                if(i>=nums.length){
                    break;
                }
            }
            while(nums[i]>nums[i-1]){
                i++;
            }

        }
        return false;
    }
}
