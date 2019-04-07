package Hash;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\2\1 0001.
 */
public class findErrorNums645 {
    @Test
    public void test(){
        int[] nums = new int[]{1,2,3,2};
        int[] info = new findErrorNums645().findErrorNums(nums);
        System.out.println(Arrays.toString(info));
    }
    public int[] findErrorNums(int[] nums) {
        int[] right = new int[nums.length];
        int[] info = new int[2];
        for(int i = 0;i<nums.length;i++){
            if(right[nums[i] - 1] == 1){
                info[0] = nums[i];
            }else{
                right[nums[i] - 1] = 1;
            }
        }
        for(int j = 0;j<nums.length;j++){
            if(right[j] == 0){
                info[1] = j + 1;
            }
        }

        return  info;
    }
}
