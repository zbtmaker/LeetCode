package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class majorityElement169 {
    public static void main(String[] args){
        int[] nums = new int[]{3,1,3};
        System.out.println(majorityElementI(nums));
    }

    /**
     * 求众数，可以用HashMap统计词频，然后扫描一遍之后求得最大值
     * @param nums
     * @return
     */
    public static int majorityElementI(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else{
                map.put(nums[i],1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>(nums.length>>1)){
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int majorityElementII(int[] nums) {
        return 0;
    }
}
