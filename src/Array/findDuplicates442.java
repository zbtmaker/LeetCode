package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019\1\20 0020.
 */
public class findDuplicates442 {
    public static void main(String[] args){
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> list = findDuplicates(nums);
        System.out.println(Arrays.toString(list.toArray()));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> array = new ArrayList<Integer>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                continue;
            }else if(nums[i] -1 != i){
                while(nums[i] != i+1 && nums[i] != 0){
                    if(nums[i] == nums[nums[i]-1]){
                        array.add(nums[i]);
                        nums[i] = 0;
                    }else{
                        int temp = nums[i];
                        nums[i] = nums[nums[i]-1];
                        nums[temp-1] = temp;
                    }
                }
            }
        }
        return array;
    }
}
