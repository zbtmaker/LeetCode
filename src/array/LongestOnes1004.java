package array;

/**
 * @author Baitao Zou
 * date 2021/02/20
 */
public class LongestOnes1004 {
    public int longestOnes(int[] arr, int k) {
        int l = 0, r = 0, max = 0;
        for (; r < arr.length; r++) {
            if (arr[r] == 0) {
                k--;
                if (k < 0 && r - l > max) {
                    max = r - l;
                }
                while (k < 0) {
                    if (arr[l] == 0) {
                        k++;
                    }
                    l++;
                }
            }
        }
        return Math.max(max, l - r);
    }
}
