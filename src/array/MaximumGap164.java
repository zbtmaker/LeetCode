package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode164:https://leetcode-cn.com/problems/maximum-gap/
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 *
 * @author baitao zou
 * date 2020/06/20
 */
public class MaximumGap164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        return maximumGapByRadixSort(nums);
    }

    /**
     * 平常开发最快能够想到的算法就是把nums数组添加到List中，然后使用
     * API提供的排序之后再进行相邻两个元素比较。这样的算法时间复杂度为
     * O(NlogN),空间复杂度为O(N).但是将元素添加到数组中的时间。这是最
     * 坏的做法。
     *
     * @param nums 数组
     * @return 最大间隔
     */
    private int maximumGapByApi(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        list.sort(Integer::compareTo);
        int max = 0;
        for (int i = 1; i < list.size(); i++) {
            max = Math.max(max, list.get(i) - list.get(i - 1));
        }
        return max;
    }

    /**
     * 采用基数排序算法实现最大Gap统计，因为所有的数字都是非负整数，所以符合基数排序的要求。
     * 那为什么不用CountingSort方式呢？因为CountingSort需要找到最大值Max，然后构建一个
     * Max+1空间的数组，所以在数据范围较大的情况下会出现空间溢出的问题。
     *
     * @param nums 非负整数数组
     * @return 最大GAP
     */
    private int maximumGapByRadixSort(int[] nums) {
        sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    /**
     * 基数排序的主体函数，为什么这里可以使用radix sort来进行排序，因为我们这里听噢给你的
     * 数据都是大于零的数据，所以对于这种大于零的输入数据，我们可以使用radix sort排序方式
     * ，算法的time complexity O(d * (n + b))。其实这种算法的实现方式也很简单，第一步找
     * 到数组中的最大值，然后堆数组中每个位进行统计排序。算法思想很简单，但是我们需要使用循环
     * 不变式来说明我们这个算法经过一系列循环之后能够得到正确的结果。
     *
     * @param nums 输入数组
     */
    public void sort(int[] nums) {
        int digitPlace = 1;
        int n = nums.length;
        int[] result = new int[n];
        int largestNum = getMax(nums);

        while (largestNum / digitPlace > 0) {
            int[] count = new int[10];

            for (int num : nums) {
                count[(num / digitPlace) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                result[count[(nums[i] / digitPlace) % 10] - 1] = nums[i];
                count[(nums[i] / digitPlace) % 10]--;
            }

            System.arraycopy(result, 0, nums, 0, n);
            digitPlace *= 10;
        }
    }

    /**
     * 找到素组中最大值
     *
     * @param nums 数组数组
     * @return 数组中的最大元素
     */
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
