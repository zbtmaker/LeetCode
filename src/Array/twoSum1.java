package Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class twoSum1 {
    public static void main(String[] args){
        int[] nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums,9)));
    }
    public static int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] sum = new int[2];
        map.put(target-nums[0],0);
        for(int i = 1;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                sum[0] = map.get(nums[i]);
                sum[1] = i;
                return sum;
            }else{
                map.put(target-nums[i],i);
            }
        }
        return sum;
    }
}
