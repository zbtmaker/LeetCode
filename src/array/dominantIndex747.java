package array;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class dominantIndex747 {
    public static void main(String[] args){
        int[] nums = new int[]{1,6,3,2};
        System.out.println(dominantIndex(nums));
    }
    public static int dominantIndex(int[] nums){
        int index = 0;
        int max = nums[0];
        boolean flag = true;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>=2*max){
                max = nums[i];
                index = i;
                flag = true;
            }else if(nums[i]>max){
                max = nums[i];
                flag = false;
            }else if(max < 2* nums[i]){
                flag = false;
            }
        }
        if(flag){
            return index;
        }else{
            return -1;
        }
    }
}
