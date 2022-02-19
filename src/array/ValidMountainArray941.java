package array;

/**
 * Created by Administrator on 2019\1\19 0019.
 */
public class ValidMountainArray941 {
    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if (len < 3) {
            return false;
        }
        // 记录升序
        int left = 0;
        while (left < len - 1) {
            if (arr[left] >= arr[left + 1]) {
                break;
            }
            left++;
        }

        // 记录降序
        int right = len - 1;
        while (right > 0) {
            if (arr[right] >= arr[right - 1]) {
                break;
            }
            right--;
        }
        // 判断升序列和降序是否重合
        return left != 0 && right != len - 1 && left == right;
    }
}
