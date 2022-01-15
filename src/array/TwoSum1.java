package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                sum[0] = map.get(nums[i]);
                sum[1] = i;
                return sum;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return sum;
    }
}
