package bit;

/**
 * @author Baitao Zou
 * date 2021/03/04
 */
public class HammingWeight {

    /**
     * 我们采用左移操作，用一个掩码方式来判断二进制的每一位是否是1，最直观的判读就是采用1，2，4，8，... 2^31次方一次和n执行
     * &操作。这样最终能够获得0～31每一位是否为1。
     * @param n
     * @return
     */
    public static int hammingWeightLeft(int n) {
        int count = 0;
        int b = 1;
        int i = 1;
        while (i <= 32) {
            if ((n & b) != 0) {
                count++;
            }
            i++;
            b = b << 1;
        }
        return count;
    }

    /**
     * 这里我们采用右移操作，对于右移操作，正整数的二进制就是其本身，但是负数的二进制采用补码的方式(二进制反码+1)，如果我们要计算
     * 负数的hammingWeight，那么我们需要采用逻辑右移，最高符号位会随着右移，而最高位就是补0。对于算术右移，最高位向右移之后，
     * 最高位还需要设置位1。其实具体的问题可以具体分析
     * @param n
     * @return
     */
    public static int hammingWeightRight(int n) {
        int count = 0, b;
        while (n != 0) {
            b = n;
            count += (b & 1);
            n >>>= 1;
        }
        return count;
    }
}
