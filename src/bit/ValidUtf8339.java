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
     *    具体参考http://www.ruanyifeng.com/blog/2007/10/ascii_unicode_and_utf-8.html
     * 时间复杂度O(8N),空间复杂度O(8N),后续待优化
     *
     * @param data
     * @return
     */
    public boolean validUtf8(int[] data) {
        int[][] bitArr = intArrToBitArr(data);
        int len = data.length;
        if (len == 1) {
            return !(bitArr[0][0] == 1);
        }
        int k = 0;
        while (k < len) {
            int[] tmp = bitArr[k];
            int m = 0;
            while (m < 8 && tmp[m] != 0) {
                m++;
            }
            if (m == 1 || m > 4 || k + m > len) {
                return false;
            }
            int j = k + 1;
            for (; j < len && j < k + m; j++) {
                if (bitArr[j][0] != 1 || bitArr[j][1] != 0) {
                    return false;
                }
            }
            k = j;
        }
        return true;
    }

    private int[][] intArrToBitArr(int[] data) {
        int len = data.length;
        int[][] bitArr = new int[len][8];
        for (int i = len - 1; i >= 0; i--) {
            int num = data[i];
            int shift = 0;
            while (shift < 8) {
                bitArr[i][8 - shift - 1] = num & 1;
                num = num >> 1;
                shift++;
            }

        }
        return bitArr;
    }
}
