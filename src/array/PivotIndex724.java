package array;

/**
 * Created by Administrator on 2019\1\19 0019.
 */
public class PivotIndex724 {

    public int pivotIndex(int[] nums) {
        int index = -1;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] + nums[i - 1];
            right[nums.length - 1 - i] = right[nums.length - i] + nums[nums.length - i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (left[i] == right[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
