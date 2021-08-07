package string;

import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/10/05
 */
public class IsIsomorphic205 {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicI(s, t);
    }

    private boolean isIsomorphicI(String s, String t) {
        int[] sPattern = getPattern(s);
        System.out.println(Arrays.toString(sPattern));
        int[] tPattern = getPattern(t);
        System.out.println(Arrays.toString(tPattern));
        for (int i = 0; i < sPattern.length; i++) {
            if (sPattern[i] != tPattern[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getPattern(String s) {
        int len = s.length();
        int[] arr = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                arr[i] = arr[i - 1];
            } else {
                arr[i] = arr[i - 1] ^ 1;
            }
        }
        return arr;
    }

    private boolean isIsomorphicOptimize(String s, String t) {

        return true;
    }
}
