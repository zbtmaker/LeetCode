package string;

import java.util.LinkedList;

/**
 * Created by Administrator on 2019\2\21 0021.
 */
public class AddStrings415 {

    public String addString(String num1, String num2) {
        return addStringsI(num1, num2);
    }

    /**
     * 这里的思路是从链表相加得来的，是因为链表没法记录前一个节点。因此使用堆栈的方式
     * 可以实现倒转。但是时间复杂度为 2N，因此时间复杂度O(N)。而空间复杂度为 2N，因此大约的空间复杂度为O(2N)
     *
     * @param num1
     * @param num2
     * @return
     */
    private String addStringsI(String num1, String num2) {
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0, basic = 0, carry = 0;
        while (index1 > -1 && index2 > -1) {
            sum = (num1.charAt(index1--) - '0') + (num2.charAt(index2--) - '0') + carry;
            basic = sum % 10;
            carry = sum / 10;
            list.addFirst(basic);
        }
        while (index1 > -1) {
            sum = (num1.charAt(index1--) - '0') + carry;
            basic = sum % 10;
            carry = sum / 10;
            list.addFirst(basic);
        }
        while (index2 > -1) {
            sum = (num2.charAt(index2--) - '0') + carry;
            basic = sum % 10;
            carry = sum / 10;
            list.addFirst(basic);
        }
        if (carry != 0) {
            list.addFirst(carry);
        }
        StringBuilder sb = new StringBuilder(list.size());
        for (Integer i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
}
