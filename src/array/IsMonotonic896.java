package array;

/**
 * Created by Administrator on 2019\1\16 0016.
 */
public class IsMonotonic896 {

    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (flag == -1) {
                    return false;
                }
                flag = 1;
            } else if (nums[i] < nums[i - 1]) {
                if (flag == 1) {
                    return false;
                }
                flag = -1;
            }
        }
        return true;
    }
}
