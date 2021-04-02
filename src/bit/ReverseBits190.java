package bit;

/**
 * @author baitao zou
 * date 2020/04/30
 */
public class ReverseBits190 {
    public int reverseBits(int n) {
        int sum = 0, count = 0;
        while (count <= 31) {
            sum = (sum << 1) + (n & 1);
            n >>>= 1;
            count++;
        }
        return sum;
    }
}
