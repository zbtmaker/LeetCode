package String;

import java.util.Stack;

/**
 * Created by Administrator on 2019\3\18 0018.
 */
public class evalRPN150 {
    public static void main(String[] args){
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};

        int result = new evalRPN150().evalRPN(tokens);
        System.out.println(result);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i <tokens.length;i++){
            String str = tokens[i];
            if(str .equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int result;
                int a = stack.pop();
                int b = stack.pop();
                switch(str){
                    case "+": result = b + a;break;
                    case "-":result = b - a;break;
                    case "*":result = b * a;break;
                    case "/":result = b / a;break;
                    default:result = 0;
                }
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
