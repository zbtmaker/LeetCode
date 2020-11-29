package bit;

/**
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * 链接:https://leetcode-cn.com/problems/number-complement/
 *
 * @author baitao zou
 * date 2020/11/29
 */
public class FindComplement476 {
    /**
     * @param num 正整数
     * @return 补数
     */
    public int findComplement(int num) {
        int[] bitArr = new int[32];
        for (int i = 0; i < 32; i++) {
            bitArr[i] = (num & 1);
            num >>= 1;
        }
        int nonZeroIndex = findFirstNonZeroIndex(bitArr);
        int result = 0;
        int shift = 1;
        for (int i = 0; i <= nonZeroIndex; i++) {
            result += Math.abs(bitArr[i] - 1) * shift;
            shift <<= 1;
        }
        return result;
    }

    /**
     * 寻找第一个不为零的比特位索引
     *
     * @param bitArr 比特数组
     * @return 第一个不为零的比特位索引
     */
    private int findFirstNonZeroIndex(int[] bitArr) {
        for (int i = bitArr.length - 1; i >= 0; i--) {
            if (bitArr[i] != 0) {
                return i;
            }
        }
        return -1;
    }
}
