package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长上升子序
 * Created by Administrator on 2019\1\23 0023.
 */
public class LengthOfLIS300 {

    /**
     * 解题思路：
     * solution1：Dynamic Programming  时间复杂度O（N^2）  空间复杂度O（N）
     * solution2：BinarySearch         时间复杂度O（NlogN) 空间复杂度O（N）
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        return lengthOfLISByBinarySearch(nums);
    }

    /**
     * 这个题目从问题的方向看就是一个动态规划的题，但是我现在能想到的方法就是使用一个aux数组来
     * 存储前面的最大长度，这样做的方案肯定的操作的步骤肯定是：sum = 1 + 2 + 3 + n-1，也就是时间复杂度为
     * O（n^2）,空间复杂度为O（n）。LeetCode运行时间：11ms,内存36.78MB。这种动态规划的方式不管是时间和空间都
     * 无法增加了，这里的空间复杂度相当于用来平衡时间复杂度了。
     *
     * @param nums
     * @return
     */
    private int lengthOfLISByDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] aux = new int[len + 1];
        aux[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            int tmpMax = 1;
            for (int j = i - 1; j > -1; j--) {

                if (nums[i] > nums[j]) {
                    tmpMax = Math.max(tmpMax, aux[j] + 1);
                }
            }
            aux[i] = tmpMax;
            max = Math.max(max, aux[i]);
        }
        return max;
    }

    /**
     * LeeCode上面有个大神用了一个时间复杂度更少的二分法来解决这个问题，这中方法很奇特，虽然也要一个O（N）的空间
     * 来维护一个数据保存一个尾数元素值最小的数组，最终数组的长度就是
     *
     * @param nums
     * @return
     */
    private int lengthOfLISByBinarySearch(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        List<Integer> aux = new ArrayList<>();
        aux.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            insertToList(nums[i], aux);
        }
        return aux.size();
    }

    /**
     * 功能：找出aux链表中刚好大于num的与元素的位置index,如果num > aux.get(index),则aux.set(index + 1,num)
     * 如果num < aux.get(index),则aux.set(index,num)
     * 那么直接将aux中index位置的元素替换为num,如果index超出了aux的索引，那么直
     * 接添加到aux当中。
     *
     * @param num 判断是否需要插入的数据
     * @param aux 插入的目标链表
     */
    private void insertToList(int num, List<Integer> aux) {
        int high = aux.size() - 1;
        if (num == aux.get(high)) {
            return;
        }
        if (num > aux.get(high)) {
            aux.add(num);
            return;
        }
        int low = 0;
        int mid = (low + high) >> 1;
        while (low < high) {
            if (num < aux.get(mid)) {
                high = mid - 1;
            } else if (num > aux.get(mid)) {
                low = mid + 1;
            } else {
                return;
            }
            mid = (low + high) >> 1;
        }
        if (aux.get(low) < num) {
            aux.set(low + 1, num);
        } else {
            aux.set(low, num);
        }
    }
}
