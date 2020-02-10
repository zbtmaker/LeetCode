package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author baitao zou
 * date 2020/02/04
 */
public class ArrayUtils {

    /**
     * 归并排序
     *
     * @param arr 排序数组
     */
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序递归
     *
     * @param arr   排序数组
     * @param left
     * @param right
     */
    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * @param arr   排序数组
     * @param mid
     * @param left
     * @param right
     */
    private void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i++];
            } else {
                arr[k] = rightArr[j++];
            }
            k++;
        }
        while (i < leftArr.length) {
            arr[k] = leftArr[i++];
            k++;
        }
        while (j < rightArr.length) {
            arr[k] = rightArr[j++];
            k++;
        }
    }

    /**
     * 快速排序
     *
     * @param arr 排序数组
     */
    public void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

    }

    /**
     * 快排递归主体
     *
     * @param arr   排序数组
     * @param left
     * @param right
     */
    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int partitionIndex = partition(arr, left, right);
        quickSort(arr, left, partitionIndex);
        quickSort(arr, partitionIndex + 1, right);
    }

    /**
     * @param arr   目标数组
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {
        return -1;
    }


    /**
     * 统计每个int类型数据出现的次数
     *
     * @param nums 数组
     * @return 统计Map
     */
    public static Map<Integer, Integer> count(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums == null || nums.length == 0) {
            return map;
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return map;
    }
}
