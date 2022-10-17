package string;

import java.util.Stack;

/**
 * Created by Administrator on 2019\3\18 0018.
 */
public class EvalRPN150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int result;
                int a = stack.pop();
                int b = stack.pop();
                switch (str) {
                    case "+":
                        result = b + a;
                        break;
                    case "-":
                        result = b - a;
                        break;
                    case "*":
                        result = b * a;
                        break;
                    case "/":
                        result = b / a;
                        break;
                    default:
                        result = 0;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
