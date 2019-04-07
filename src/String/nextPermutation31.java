package String;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\3\1 0001.
 */
public class nextPermutation31 {
    public static void main(String[] args){
        int[] nums = new int[]{1};
        new nextPermutation31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        boolean flag = true;
        for(int i = nums.length-1;i>0;i--){
            if(nums[i] > nums[i-1]){
                int tmp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = tmp;
                flag = false;
                break;
            }
        }
        if(flag){
            inverse(nums);
        }
    }
    private void inverse(int[] nums){
        int i = 0;
        int j = nums.length-1;

        while(i<j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
