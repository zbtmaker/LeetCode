package array;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * @author baitao zou
 * date 2020/02/10
 */
public class SingleNumber260 {

    /**
     * 这种方法和SingleNumber136、SingleNumber137相似。
     * 方法一：HashMap统计，time complexity O(N), space complexity O(N)
     * 方法二：XOR异或运算，time complexity O(N), space complexity O(1)
     *
     * @param nums 目标数组
     * @return 只出现一次的数字集合
     */
    public int[] singleNumber(int[] nums) {
        return singleNumberByHashMap(nums);
    }

    /**
     * 通过HashMap的统计方式来实现，time complexity为O(N),space complexity
     * 为O(N).
     *
     * @param nums 目标数组
     * @return 只出现一次的数字集合
     */
    private int[] singleNumberByHashMap(int[] nums) {
        Map<Integer, Integer> map = ArrayUtils.count(nums);
        List<Integer> result = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 采用两次XOR操作的方式可以得到我们想要的结果
     *
     * @param nums 目标数组
     * @return 只出现一次的数字集合
     */
    private int[] singleNumberByXOR(int[] nums) {
        return new int[2];
    }
}
