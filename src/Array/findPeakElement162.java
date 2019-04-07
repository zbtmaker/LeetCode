package Array;

/**
 * Created by Administrator on 2019\2\27 0027.
 */
public class findPeakElement162 {
    public int findPeakElement(int[] nums) {

        for(int i = 0;i<nums.length;i++){
            if(i == 0 && nums[i] > nums[i+1]){
                return i;
            }else if(i == nums.length-1 && nums[i]>nums[i-1]){
                return i;
            }else if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                return i;
            }
        }
        return 0;
    }
}
