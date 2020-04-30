package math;

/**
 * @author baitao zou
 * date 2020/04/30
 */
public class ReverseBits190 {
    public int reverseBits(int n) {
        int result = 0;
        for (int bit = 31; bit >= 0; bit--) {
            result += (n & 1) << bit;
            n = n >>> 1;
        }
        return result;
    }
}
