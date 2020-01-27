package string;

import org.junit.Test;

/**
 * Created by Administrator on 2019\2\8 0008.
 */
public class reverseString344 {
    @Test
    public void test() {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        new reverseString344().reverseString(s);
        System.out.println(s);
    }

    /**
     * 双指针问题
     * @param s
     */
    public void reverseString(char[] s) {
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
