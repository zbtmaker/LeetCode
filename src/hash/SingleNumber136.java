package hash;


import java.util.HashMap;
import java.util.Map;

/**
 * @author baitao zou
 * date 2019/01/30
 */
public class SingleNumber136 {

    public int singleNumber(int[] nums) {
        /*return singleNumberByHashMap(nums);*/
        return singleNumberByXOR(nums);
    }

    /**
     * 对于这种统计重复元素的问题，首先想到的就是使用HashMap来统计重复的元素
     * 出现的次数，然后判断哪个元素的出现的次数只有1。
     *
     * @param nums 目标数组
     * @return 只出现一次的函数
     */
    private int singleNumberByHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 使用逻辑电路中的异或思想，a^0 = a,a^b^a = a^a^b = 0^b =b
     * 由于题目中明确提示，所有的字符都会出现两次，那么这个时候通过一连串的
     * 异或操作后，由于两个相同元素之间的异或为0，最后剩下的哪个元素肯定就是
     * 我们要找的只出现一次的元素。这种算法使time complexityO(N),space complexity O(1)
     * Beautiful code!
     *
     * @param nums 目标数组
     * @return 只出现一次的元素
     */
    private int singleNumberByXOR(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] ^ nums[i - 1];
        }
        return nums[nums.length - 1];
    }
}
