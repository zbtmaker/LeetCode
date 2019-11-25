package hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\31 0031.
 */
public class containsNearbyDuplicate219 {
    @Test
    public void test(){
        boolean flag = new containsNearbyDuplicate219().containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2);
        System.out.println(flag);
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && i-map.get(nums[i]) <= k){
                return true;
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
