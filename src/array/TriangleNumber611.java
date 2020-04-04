package array;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * @author baitao zou
 * date 2020/04/04
 */
public class TriangleNumber611 {

    /**
     * 一个有效的三角形一定是任意两边之和一定大于第三边，这里我们通过排序的方式
     * 很快就能解决当前的问题。排好序的只要满足最小两条边之和大于第三条边就可以了。
     * 那么这个题目有没有更好的解法，这种方法的时间复杂度为O(NlogN),有没有更好的解决算法。
     *
     * @param nums 数组
     * @return 可以构成三角形的个数
     */

    public int triangleNumber(int[] nums) {
//        return validateTriangleByBruteForce(num);
        return triangleNumberBySortAndBinarySearch(nums);
    }

    /**
     * 一个有效的三角形一定是任意两边之和一定大于第三边.这里可以通过三个指针
     * 也就是枚举所有的结果
     *
     * @param nums 数组
     * @return 可以构成三角形的个数
     */
    private int triangleNumberByBruteForce(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[j] + nums[k] > nums[i])
                        count++;
                }
            }
        }
        return count;
    }


    /**
     * 给了一个好的算法思路，就是我们先把数组排好序，然后使用一个二元
     * 指针来指向前面的数组，然后通过二分法的方式寻找下一个数。给定两个
     * 指针i , j,由于那么我们就是使用二分法在[j,num.length-1]区间
     * 里面找到一个大于num[i] + num[j]的数。那么这个时候我们可以将上
     * 一个方法的最里层的时间复杂度从O(N)优化到O(logN)。因此时间复杂度就变成了
     * O(N^2logN).空间负载度就变成了O(1)
     *
     * @param nums
     * @return
     */
    private int triangleNumberBySortAndBinarySearch(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] == 0) {
                    continue;
                }
                int target = nums[i] + nums[j];
                int index = binarySearch(j + 1, target, nums);
                count += index - j;
            }
        }
        return count;
    }

    /**
     * 返回一个在区间[left,num.length - 1]范围内小于target的
     * 最大的那个index。如果所有的元素都比target大，则返回left - 1。
     * 如果所有的元素都比target小，则返回num.length - 1
     *
     * @param left
     * @param target
     * @param nums
     * @return
     */
    public int binarySearch(int left, int target, int[] nums) {
        int right = nums.length - 1;
        int middle = (left + right) >> 1;
        while (left <= right) {
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                break;
            }
            middle = (left + right) >> 1;
        }
        if (middle == -1) {
            return middle;
        }
        if (target < nums[middle]) {
            return left - 1;
        }
        while (target == nums[middle]) {
            middle--;
        }
        return middle;
    }
}
