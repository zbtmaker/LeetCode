package array;


/**
 * Created by Administrator on 2019\1\7 0007.
 */
public class RemoveElements26 {

    public int removeElement(int[] nums) {
        return byDoublePointer(nums);
    }

    private int byDoublePointer(int[] nums) {
        int len = nums.length, slow = 0, fast = 1;
        while (fast < len) {
            if (nums[fast] != nums[fast - 1]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    private int byDoublePointerII(int[] nums) {
        int len = nums.length, i = 0, index = 0;
        while (i < len) {
            int k = i + 1;
            while (k < len && nums[k] == nums[i]) {
                k++;
            }
            ArrayUtils.swap(nums, i, index);
            i = k;
            index++;
        }
        return index;
    }
}
