package string;

/**
 * @author zoubaitao
 * date 2022/04/03
 */
public class StringUtils {

    public static String reverse(String s) {
        char[] chs = s.toCharArray();
        reverse(chs);
        return String.valueOf(chs);
    }

    public static void reverse(char[] chs) {
        reverse(chs, 0, chs.length - 1);
    }

    public static void reverse(char[] chs, int left, int right) {
        while (left < right) {
            char tmp = chs[left];
            chs[left] = chs[right];
            chs[right] = tmp;
            left++;
            right--;
        }
    }
}
