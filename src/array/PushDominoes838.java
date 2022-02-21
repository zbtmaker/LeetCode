package array;

import java.util.Arrays;

/**
 * @author zoubaitao
 * date 2022/02/21
 */
public class PushDominoes838 {
    public String pushDominoes(String dominoes) {
        return byDoublePointerAndLoop(dominoes);
    }

    private String byDoublePointerAndLoop(String dominoes) {
        char[] chs = dominoes.toCharArray();
        int len = dominoes.length(), i = 0;
        while (i < len) {
            char curChar = chs[i];
            if (curChar != '.') {
                i++;
                continue;
            }
            int k = i + 1;
            while (k < len && chs[k] == chs[k - 1]) {
                k++;
            }
            if (k < len) {
                if (i >= 1 && chs[i - 1] == 'R') {
                    if (chs[k] == 'L') {
                        int left = i, right = k - 1;
                        while (left < right) {
                            chs[left++] = 'R';
                            chs[right--] = 'L';
                        }
                        if (((right - left + 1) & 1) != 0) {
                            chs[left] = '.';
                        }
                    } else {
                        Arrays.fill(chs, i, k, 'R');
                    }
                } else {
                    char ch = chs[k] == 'L' ? 'L' : '.';
                    Arrays.fill(chs, i, k, ch);
                }
            } else {
                char ch = i >= 1 && chs[i - 1] == 'R' ? 'R' : '.';
                Arrays.fill(chs, i, k, ch);
            }
            i = k;
        }
        return String.valueOf(chs);
    }
}
