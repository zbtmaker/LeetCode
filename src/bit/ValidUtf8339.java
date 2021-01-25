package bit;

/**
 * @author Baitao Zou
 * date 2021/01/25
 */
public class ValidUtf8339 {
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
            if (m == 1 || m == 8 || k + m > len) {
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
