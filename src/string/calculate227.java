package string;

import org.junit.Test;

import java.util.Stack;

public class calculate227 {
    @Test
    public void test1(){
        String s = "123";
        System.out.println(s.substring(1,1));
    }
    @Test
    public void test(){
        calculate227 cal = new calculate227();
        int result = cal.calculate("5/2*6");
        System.out.println(result);
    }
    /**
     * 基本计算器，没有括号，只有 + - * /操作，基本思想就是入栈，
     * @param s
     * @return
     */
    public int calculate(String s) {
        s = trim(s);
        int i = 0;
        int len = s.length();
        Stack<String> stack = new Stack<String>();
        Integer result = null;
        Integer now = null;
        int numStart= 0;
        while(i < len){
            char ch = s.charAt(i);
            while(ch >= '0' && ch <= '9'){
                i ++;
                if(i >= len){
                    break;
                }
                ch = s.charAt(i);
            }
            stack.push(s.substring(numStart,i));
            numStart = i;
            if(ch == '-' || ch == '+'){
                stack.push(ch+"");
                i ++;
                numStart = i;
            }else if(ch == '*'){
                Integer last = Integer.parseInt(stack.pop());
                int start = ++i;
                ch = s.charAt(i);
                while(ch >= '0' && ch <= '9'){
                    i++;
                    if(i >= len){
                        break;
                    }
                    ch = s.charAt(i);
                }
                now= Integer.parseInt(s.substring(start,i));
                result = last * now;
                stack.push(result+"");
                numStart = i;
            }else if(ch == '/'){
                Integer last = Integer.parseInt(stack.pop());
                int start = ++i;
                ch = s.charAt(i);
                while(ch <= '9' && ch >= '0'){
                    i++;
                    if(i >= len){
                        break;
                    }
                    ch = s.charAt(i);
                }
                now= Integer.parseInt(s.substring(start,i));
                result = last / now;
                stack.push(result+"");
                numStart = i;
            }
        }
        result = Integer.parseInt(stack.pop());
        while(!stack.isEmpty()){
            String str = stack.pop();
            if("-".equals(str)){
                result = Integer.parseInt(stack.pop()) - result;
            }else if("+".equals("str")){
                result = Integer.parseInt(stack.pop()) + result;
            }
        }
        return result;
    }

    /**
     * 用这个方案去除字符串中的空字符
     * @param s
     * @return
     */
    private String trim(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length();i ++){
            char ch = s.charAt(i);
            if(ch != ' '){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
