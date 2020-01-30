package array;

/**
 * @author baitao zou
 * date 2020/01/30
 */
public class Merge88 {
    /**
     * 归并排序的一部分,但是做不到原地。还有优化的空间，时间复杂度为O(M+N),空间复杂度为O(M+N)
     *
     * @param nums1 目标数组
     * @param m     长度
     * @param nums2 源数组
     * @param n     长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                result[k] = nums1[i++];
            } else {
                result[k] = nums2[j++];
            }
            k++;
        }
        while (i < m) {
            result[k++] = nums1[i++];
        }
        while (j < n) {
            result[k] = nums2[j];
            j++;
            k++;
        }
        for (int p = 0; p < nums1.length; p++) {
            nums1[p] = result[p];
        }
    }
}
