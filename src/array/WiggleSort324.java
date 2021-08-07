package array;

import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/05/06
 */
public class WiggleSort324 {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int[] aux = new int[nums.length];
        int i = 0;
        while (left < right) {
            aux[i++] = nums[left++];
            aux[i++] = nums[right--];
        }
        if (left == right) {
            aux[i] = nums[left];
        }
        System.arraycopy(aux, 0, nums, 0, nums.length);
    }
}
