package stack;

import java.util.Stack;

/**
 * @author baitao zou
 * date 2020/01/28
 */
public class MinStack155 {

    /**
     *
     */
    private Stack<Integer> pushStack;
    /**
     * 保存最小值的辅助栈
     */
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack155() {
        pushStack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 这里
     * @param x
     */
    public void push(int x) {
        pushStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int min = minStack.peek();
            if (x <= min) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int val = pushStack.pop();
        int min = minStack.peek();
        if(val == min){
            minStack.pop();
        }
    }

    public int top() {
        return pushStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
