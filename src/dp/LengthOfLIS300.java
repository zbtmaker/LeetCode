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
     * 根据前面的提出的动态规划，指针i如果想要找到[0,i-1]比指针i的数值更小，那么 我们需要找到所有比指针i小的所有索引。
     * 那么如果我们把每一个最长上升子序列长度的最大值存起来，比方说，数组[1, 3, 6, 7, 9, 4, 10, 5, 6]，那么我们可以
     * [1]
     * [1, 3]
     * [1, 3, 6, 7]
     * [1, 3, 6, 7, 9]
     * 此时下一个元素是4，因此这个元素和前面所有元素来说能够构成的一个最长上升子序列为[1,3,4]，[1,3,6]，如果后面再出现一个元素
     * 5，那么能够构成的最长的序列就是[1, 3, 4, 5]。因此对于长度为3的最长上升子序列来说，4比6更合适。所以我们就可以用4这个元素来
     * 替换6这个元素。
     * 我们用数组aux来存储每个数组的元素，其中aux[i]表示长度为i+1的严格上升子序列最小的一个满足条件的元素。这种方式其实和单调队列的
     * 思想有点像。如果能够在越后面找到一个比当前位置更小的元素，那么这个元素是有利于形成一个更长的上升子序列的，所以就需要aux数组维护一个
     * 有序的单调递增的队列。
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
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            if (cur > aux.get(aux.size() - 1)) {
                aux.add(cur);
            } else {
                int index = findMinIndex(nums[i], aux);
                aux.set(index, cur);
            }
        }
        return aux.size();
    }

    /**
     * 功能：找出aux链表中刚好大于num的与元素的位置index；
     * <p>
     * 如果num > aux.get(index)，则aux.set(index + 1,num)；
     * <p>
     * 如果num < aux.get(index)，则aux.set(index,num)；
     * <p>
     * 如果index超出了aux的索引，那么直接添加到aux当中。
     *
     * @param num 判断是否需要插入的数据
     * @param aux 插入的目标链表
     */
    private int findMinIndex(int num, List<Integer> aux) {
        int left = 0;
        int right = aux.size() - 1;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (aux.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
