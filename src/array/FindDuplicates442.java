package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zoubaitao
 * date 2019/1/20
 */
public class FindDuplicates442 {

    public List<Integer> findDuplicates(int[] nums) {
        return bySwap(nums);
    }

    /**
     * 通过HashMap统计每个数字出现的次数解决问题，时间复杂度O(1), 空间复杂度O(N)
     *
     * @param nums 数组
     * @return 出现两次的元素集合
     */
    private List<Integer> bySet(int[] nums) {
        Set<Integer> set = new HashSet<>();

        List<Integer> duplicates = new LinkedList<>();
        for (int num : nums) {
            if (set.contains(num)) {
                duplicates.add(num);
            } else {
                set.add(num);
            }

        }
        return duplicates;
    }

    /**
     * 因为nums数组中所有元素都满足1≤nums[i]≤n，如果有元素出现两次，有元素出现一次，那么肯定是那些出现两次的元素
     * 占用了那些没有出现元素的次数，每次都进行交换，交换完成之后，将多余的那个数字出现的位置设置为0，修改数组的方式
     * 是防止重复添加的问题。
     *
     * @param nums 数组
     * @return 出现两次的元素集合
     */
    private List<Integer> bySwap(int[] nums) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != 0) {
                if (nums[i] == nums[nums[i] - 1]) {
                    array.add(nums[i]);
                    nums[i] = 0;
                    break;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[nums[i] - 1];
                    nums[temp - 1] = temp;
                }
            }
        }
        return array;
    }
}
