package string;

/**
 * @author zoubaitao
 * date 2022/02/23
 */
public class ReverseOnlyLetters917 {

    public String reverseOnlyLetters(String s) {
        char[] chs = s.toCharArray();
        int left = 0, right = chs.length - 1;
        while (left < right) {
            boolean leftFlag = isCharacter(chs[left]), rightFlag = isCharacter(chs[right]);
            if (leftFlag && rightFlag) {
                swap(chs, left++, right--);
            } else if (leftFlag) {
                right--;
            } else if (rightFlag) {
                left++;
            } else {
                right--;
                left++;
            }
        }
        return String.valueOf(chs);
    }

    private boolean isCharacter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    private void swap(char[] chs, int left, int right) {
        char tmp = chs[left];
        chs[left] = chs[right];
        chs[right] = tmp;
    }
}
