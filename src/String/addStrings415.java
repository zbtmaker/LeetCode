package String;

import java.util.Stack;

/**
 * Created by Administrator on 2019\2\21 0021.
 *
 */
public class addStrings415 {
    public static void main(String[] args){
        String num1 = "3";
        String num2 = "456";
        /*StringBuilder sb = new StringBuilder();
        sb.append(0);
        System.out.println(sb);*/
        System.out.println(new addStrings415().addStringsII(num1,num2));
    }

    /**
     * 这里的思路是从链表相加得来的，是因为链表没法记录前一个节点。因此使用堆栈的方式
     * 可以实现倒转。但是时间复杂度为 2N，因此时间复杂度O(N)。而空间复杂度为 2N，因此大约的空间复杂度为O(2N)
     * @param num1
     * @param num2
     * @return
     */
    public String addStringsI(String num1, String num2) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        push(stack1,num1);
        push(stack2,num2);

        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int basic = 0;
        int carry = 0;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            sum = (stack1.pop() - '0') + (stack2.pop() - '0') + carry;
            basic = sum % 10;
            carry = sum / 10;
            sb.insert(0,basic+"");
        }
        while(!stack1.isEmpty()){
            sum = (stack1.pop() - '0') + carry;
            basic = sum % 10;
            carry = sum / 10;
            sb.insert(0,basic+"");
        }
        while(!stack2.isEmpty()){
            sum = (stack2.pop() - '0') + carry;
            basic = sum % 10;
            carry = sum / 10;
            sb.insert(0,basic+"");
        }
        if(carry != 0){
            sb.insert(0,carry+"");
        }
        return sb.toString();
    }
    private void push(Stack<Character> stack,String num){
        for(int i = 00;i<num.length();i++){
            stack.push(num.charAt(i));
        }
    }

    /**
     * 但是对于字符串我们可以通过指针直接指向字符串的末尾，并通过移动指针来实现，因此我们的字符串相加算法
     * 的时间复杂度为O(N)，其中N为最长max{l1.length,l2.length}，且空间复杂度为O(1)
     * @param num1
     * @param num2
     * @return
     */
    public String addStringsII(String num1, String num2) {
        int i1 = num1.length()- 1;
        int i2 = num2.length() -1;

        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int basic = 0;
        int carry = 0;

        while(i1> -1 && i2 >-1){
            sum = (num1.charAt(i1--)-'0') + (num2.charAt(i2--) -'0') + carry;
            basic = sum % 10;
            carry = sum / 10;
            sb.append(basic);

        }
        while(i1 > -1){
            sum = (num1.charAt(i1--)-'0') + carry;
            basic = sum % 10;
            carry = sum / 10;
            sb.append(basic);
        }
        while(i2 > -1){
            sum = (num2.charAt(i2--)-'0') + carry;
            basic = sum % 10;
            carry = sum / 10;
            sb.append(basic);
        }
        if(carry != 0){
            sb.append(carry);
        }
        return inverse(sb);

    }
    private String inverse(StringBuilder sb){
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
