package Hash;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\30 0030.
 */
public class singleNumber136 {
    @Test
    public void test(){
        int[] nums = {1,4,2,1,2};
        int num = new singleNumber136().singleNumber(nums);
        System.out.println(num);
    }
    public int singleNumber(int[] nums){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
