package bit;

/**
 * @author Baitao Zou
 * date 2021/01/25
 */
public class ValidUtf8339 {
    /**
     * 这个题目的点主要是在
     * 1、每一个Utf8字符长度最大为4
     * 2、每一个Utf8字符的第一个byte决定了后面还需要几个byte，例如，11100000，这里表示包含当前的byte，后面一定要包含2个byte，不能多也不能少
     * 3、这里给定的数组并不是只是单个Utf8字符，而是表示一串Utf8字符经过编码后的字符串，所以一定要理解题意，在做题之前最好了解一下Utf8是如何编码的，
     * 具体参考http://www.ruanyifeng.com/blog/2007/10/ascii_unicode_and_utf-8.html
     * 时间复杂度O(N),空间复杂度O(1),后续待优化
     *
     * @param data Utf8编码字符串
     * @return true-有效Utf8编码 false-无效Utf8编码
     */
    public boolean validUtf8(int[] data) {
        int len = data.length;
        int k = 0;
        int m;
        while (k < len) {
            m = bitCount(data[k]);
            if (m == 1 || m > 4 || k + m > len) {
                return false;
            }
            int j = k + 1;
            for (; j < len && j < k + m; j++) {
                int cur = data[j];
                if ((cur & 128) == 0 || (cur & 64) == 64) {
                    return false;
                }
            }
            k = j;
        }
        return true;
    }

    /**
     * 统计最低八位的前5位有多少为1的比特位
     *
     * @param data 数字
     * @return 为1的比特位和
     */
    private int bitCount(int data) {
        int shift = 128;
        int count = 0;
        while (shift >= 8) {
            int bit = data & shift;
            if (bit == 0) {
                return count;
            }
            count++;
            shift = shift >> 1;

        }
        return count;
    }
}
