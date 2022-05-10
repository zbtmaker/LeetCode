package string;

/**
 * @author zoubaitao
 * date 2022/03/27
 */
public class StringCommonUtils {

    public static String reverse(String str) {
        char[] chs = str.toCharArray();
        return new String(chs);
    }

    public static void reverse(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
