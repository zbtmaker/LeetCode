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
        int sum = 0, mask = 0;
        while (num != 0) {
            sum += (1 ^ (num & 1)) << mask;
            mask++;
            num >>>= 1;
        }
        return sum;
    }
}
