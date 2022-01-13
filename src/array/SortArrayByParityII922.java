package array;

/**
 * Created by Administrator on 2019\1\17 0017.
 */
public class SortArrayByParityII922 {

    public int[] sortArrayByParityII(int[] nums) {
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            while ((nums[i] & 1) == 0) {
                i += 2;
                if (i >= nums.length) {
                    break;
                }
            }
            while ((nums[j] & 1) == 1) {
                j += 2;
                if (j >= nums.length) {
                    break;
                }
            }
            if (i < nums.length && j < nums.length) {
                swap(nums, i, j);
            }
        }

        return nums;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
