package array;

/**
 * LeetCode4:https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * @author baitao zou
 * date 2020/07/05
 */
public class FindMedianSortedArrays4 {

    /**
     * 这个题目的提示方法的时间复杂度为O(log(m + n)),那么肯定是能够采用二分法的方式完成，但是
     * 我这里采用一个空间为O(m + n)的数组来维护一个排好序的数组，这里其实采用的是合并排序中的merge
     * 算法思想。然后判断数组长度是奇数还是偶数，如果数组长度为奇数，那么返回有序数组的中间位置，如果
     * 数组长度为偶数，那么返回中间两个位置的元素的平均值。
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                num[k] = nums1[i++];
            } else {
                num[k] = nums2[j++];
            }
            k++;
        }
        while (i < nums1.length) {
            num[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            num[k++] = nums2[j++];
        }
        if (num.length == 1) {
            return num[0];
        }
        int middle = (num.length - 1) >> 1;
        return (num.length & 1) == 1 ? (double) num[middle] : (double) (num[middle] + num[middle + 1]) / 2;
    }
}
