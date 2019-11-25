package array;

/**
 * Created by Administrator on 2019\1\20 0020.
 */
public class findDuplicate287 {
    public static void main(String[] args){
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                continue;
            }else if(nums[i] -1 != i){
                while(nums[i] != i+1 && nums[i] != 0){
                    if(nums[i] == nums[nums[i]-1]){
                        return nums[i];
                    }else{
                        int temp = nums[i];
                        nums[i] = nums[nums[i]-1];
                        nums[temp-1] = temp;
                    }
                }
            }
        }
        return 0;
    }
}
