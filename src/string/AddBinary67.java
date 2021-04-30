package string;

import java.util.LinkedList;

/**
 * Created by Administrator on 2019\3\1 0001.
 */
public class AddBinary67 {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i1 = a.length() - 1, i2 = b.length() - 1;
        LinkedList<Integer> list = new LinkedList<>();
        while (i1 > -1 && i2 > -1) {
            int tmpA = a.charAt(i1--) - '0';
            int tmpB = b.charAt(i2--) - '0';
            int basic = tmpA ^ tmpB ^ carry;
            carry = (tmpA & tmpB) | (carry & (tmpA ^ tmpB));
            list.addFirst(basic);
        }
        while (i1 > -1) {
            int tmpA = a.charAt(i1--) - '0';
            int basic = tmpA ^ carry;
            carry = tmpA & carry;
            list.addFirst(basic);
        }
        while (i2 > -1) {
            int tmpB = b.charAt(i2--) - '0';
            int basic = tmpB ^ carry;
            carry = tmpB & carry;
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
