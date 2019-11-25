package array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\2\28 0028.
 */
public class plusOne66 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(new plusOne66().plusOne(new int[]{})));
    }

    /**
     * 如果
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return digits;
        }
        int carry = 1;
        for(int i = digits.length - 1;i>-1;i--){
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if(carry != 0){
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            for(int i = 0;i<digits.length;i++){
                result[i+1] = digits[i];
            }
            return result;
        }else{
            return digits;
        }
    }
}
