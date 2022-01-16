package array;

/**
 * Created by Administrator on 2019\2\28 0028.
 */
public class PlusOne66 {

    /**
     * 如果
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int carry = 1;
        for (int i = digits.length - 1; i > -1; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry != 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        } else {
            return digits;
        }
    }
}
