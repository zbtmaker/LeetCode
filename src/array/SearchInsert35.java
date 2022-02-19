package array;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class SearchInsert35 {
    public int searchInsert(int[] nums, int target) {
        int index = -1, left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 1;
            if (nums[middle] > target) {
                right = middle - 1;
                if (left > right) {
                    index = middle;
                }
            } else if (nums[middle] < target) {
                left = middle + 1;
                if (left > right) {
                    index = middle + 1;
                }
            } else {
                return middle;
            }
        }
        return index;
    }
}
