package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zoubaitao
 * date 2022/03/12
 */
public class CountSmaller315 {

    public List<Integer> countSmaller(int[] nums) {
        return byBruteforce(nums);
    }

    /**
     * 采用暴力的方式，时间复杂度O(N^2), 空间复杂度O(1)
     *
     * @param nums 数组
     * @return 统计数组
     */
    private List<Integer> byBruteforce(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                if (cur > nums[j]) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }

    private List<Integer> byBinarySearch(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>(len);
        return result;
    }
}
