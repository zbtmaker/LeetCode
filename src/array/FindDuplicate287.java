package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2019\1\20 0020.
 */
public class FindDuplicate287 {

    public int findDuplicate(int[] nums) {
        return findDuplicateBySwap(nums);
    }

    /**
     * 通过HashMap方式统计数组中的数据，时间复杂度O(N), 空间复杂度O(N)
     *
     * @param nums 数组
     * @return 重复的数
     */
    private int findDuplicateByMap(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length - 1);
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /**
     * 数组中只有一个元素重复，所以我们可以将不在对应位置的元素通过交换的方式，
     * 交换到对应的位置上去。还是要证明
     *
     * @param nums 数组
     * @return 重复的数
     */
    private int findDuplicateBySwap(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                } else {
                    int temp = nums[i];
                    nums[i] = nums[nums[i] - 1];
                    nums[temp - 1] = temp;
                }
            }
        }
        return 0;
    }
}
