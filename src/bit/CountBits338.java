package bit;

/**
 * @author Baitao Zou
 * date 2021/03/04
 */
public class CountBits338 {
    /**
     * 对于这个题目最初的想法就是计算每一个数字的位1的数量，但是这种方式的时间复杂度为O(N*32)，空间复杂度位O(1)。
     * 这里有个规律，对于一个偶数i，比其比特位数量等于i >> 1的比特位，这是因为4 =2 * 2 = 2 << 1， 6 = 3 * 2 = 3 << 1。
     * 所以bit[i] = bit[i >> 1],如何判断一个数是否是偶数，其实就是 i & 1 == 0 表明i就是一个偶数
     * 那么奇数呢？我们知道3 = 2 + 1，就是在偶数的最低位设置位零，而且不会导致进位。通过这种方式，如果i & 1 != 0就表示
     * 我们的i是一个奇数，那么i - 1肯定就是一个偶数，而我们在上面已经得到了偶数的递推关系式了，因此最终的关系如下：
     * i & 1 == 0 ? bit[i] = bit[i >> 1] : bit[i - 1] + 1
     * 我们就能得到
     * bit[i] = bit[i - 1] + 1.
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = (i & 1) == 0 ? bits[i >> 1] : bits[i - 1] + 1;
        }
        return bits;
    }
}
