package string;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\23 0023.
 */
public class CountSubstrings647 {
    public int countSubstrings(String s) {
        return countSubstringsByManacher(s);
    }

    /**
     * 使用Manacher算法解决问题
     *
     * @param s
     * @return
     */
    private int countSubstringsByManacher(String s) {
        s = preManacher(s);
        int[] radius = manacher(s);
        int sum = 0;
        for (int i = 0; i < radius.length; i++) {
            sum += radius[i] >> 1;
        }
        return sum;
    }

    private int[] manacher(String str) {
        char[] chs = str.toCharArray();
        int[] radius = new int[chs.length];
        Arrays.fill(radius, 1);
        int R = -1;
        int center = -1;
        for (int i = 0; i < chs.length; i++) {
            if (i > R || i + radius[2 * center - i] - 1 == R) {
                int temp = i > R ? i : center;
                int count = radius[2 * temp - i];
                int left = i - radius[2 * temp - i];
                int right = i + radius[2 * temp - i];
                while (left >= 0 && right < chs.length && chs[left] == chs[right]) {
                    count++;
                    left--;
                    right++;
                }
                radius[i] = count;
                if (R < right - 1) {
                    center = i;
                    R = right - 1;
                }
            } else if (i + radius[2 * center - i] - 1 > R) {
                radius[i] = R - i + 1;
            } else {
                radius[i] = radius[2 * center - i];
            }
        }
        return radius;
    }

    private String preManacher(String str) {
        StringBuilder sb = new StringBuilder(str.length() >> 1 + 1);

        for (int i = 0; i < str.length(); i++) {
            sb.append('#');
            sb.append(str.charAt(i));
        }
        sb.append('#');
        return sb.toString();
    }
}
