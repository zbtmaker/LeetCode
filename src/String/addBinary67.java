package String;

/**
 * Created by Administrator on 2019\3\1 0001.
 */
public class addBinary67 {
    public static void main(String[] args){
        addBinary67 add = new addBinary67();
        System.out.println(add.addBinary("11","1"));
    }
    public String addBinary(String a, String b) {
        if(a.length() == 0 && b.length() ==0){
            return a;
        }
        if(a.length() == 0){
            return b;
        }
        if(b.length() == 0){
            return a;
        }

        int carry = 0;
        int i1 = a.length()-1;
        int i2 = b.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i1>-1 && i2>-1){
            int tmpA = a.charAt(i1)-'0';
            int tmpB = b.charAt(i2)-'0';
            int basic = tmpA ^ tmpB ^ carry;
            carry =(tmpA & tmpB) | (carry & (tmpA ^ tmpB));
            sb.append(basic);
            i1 --;
            i2 --;
        }
        while(i1 > -1){
            int tmpA = a.charAt(i1)-'0';
            int basic = tmpA ^ carry;
            carry = tmpA & carry;
            sb.append(basic);
            i1 --;
        }
        while(i2 > -1){
            int tmpB = b.charAt(i2)-'0';
            int basic = tmpB ^ carry;
            carry = tmpB & carry;
            sb.append(basic);
            i2 --;
        }
        if(carry != 0){
            sb.append(carry);
        }
        return inverse(sb);

    }
    public String inverse(StringBuilder sb){
        char[] chs = sb.toString().toCharArray();
        int i = 0;
        int j = chs.length-1;
        while(i<j){
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
        return new String(chs);
    }
}
