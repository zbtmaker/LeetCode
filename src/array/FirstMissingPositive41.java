package array;

import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/06/16
 */
public class FirstMissingPositive41 {
    /**
     * method1: 统计排序
     * method2: 一般排序
     *
     * @param nums 数组
     * @return 第一个缺失的正整数
     */
    public int firstMissingPositive(int[] nums) {
        return firstMissingPositiveBySort(nums);
    }

    /**
     * 在数很小的情况下可以借助统计排序的算法思想是可以实现时间复杂度为O(n),空间复杂度为O(N)的。
     * 但是题目要求的是常数空间空间复杂度。所以这种方式并不适合。
     *
     * @param nums
     * @return
     */
    private int firstMissingPositiveByCountingSort(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int max = -1;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        if (max <= 0) {
            return 1;
        }
        int[] aux = max == Integer.MAX_VALUE ? aux = new int[max] : new int[max + 1];
        for (int num : nums) {
            if (num <= 0) {
                aux[0]++;
            } else {
                aux[num]++;
            }
        }
        for (int i = 1; i <= max; i++) {
            if (aux[i] == 0) {
                return i;
            }
        }
        return max + 1;
    }

    /**
     * 采用数组排序方式然后找到第一个不为负数的索引值，然后判断第一个缺失的整数
     *
     * @param nums 数组
     * @return 第一个缺失的正整数
     */
    public int firstMissingPositiveBySort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int index = findFirstPositive(nums);
        if (index == -1 || nums[index] != 1) {
            return 1;
        }
        if (index == nums.length - 1) {
            return nums[index] + 1;
        }
        while (index < len - 1 && (nums[index] == nums[index + 1] || nums[index] + 1 == nums[index + 1])) {
            index++;
        }
        return nums[index] + 1;
    }

    /**
     * 返回第一个不为负数的索引
     *
     * @param nums 数组
     * @return 不为负数的索引
     */
    private int findFirstPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        return -1;
    }
}
