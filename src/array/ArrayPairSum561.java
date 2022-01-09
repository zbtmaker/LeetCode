package array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\10 0010.
 */
public class ArrayPairSum561 {

    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
