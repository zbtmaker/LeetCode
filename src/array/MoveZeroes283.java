package array;

/**
 * Created by Administrator on 2019\1\17 0017.
 */
public class MoveZeroes283 {

    public void moveZeroes(int[] nums) {
        bySwap(nums);
    }

    private void byCopy(int[] nums) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (nums[i] == 0) {
                int temp = nums[i];
                int k = i + 1;
                for (; k < j; k++) {
                    nums[k - 1] = nums[k];
                }
                nums[k - 1] = temp;
                j--;
            }
            if (nums[i] != 0) {
                i++;
            }

        }
    }

    /**
     * 用一个指针point位置记录非零的位置，每记录一个非零数字，则指针向右移动，
     * 将大于point位置的元素置0。
     *
     * @param nums 数组
     */
    private void bySwap(int[] nums) {
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[point] = nums[i];
                if (i != point) {
                    nums[i] = 0;
                }
                point++;
            }
        }
    }
}
