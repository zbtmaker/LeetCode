package stack;

import java.util.Stack;

/**
 * @author baitao zou
 * date 2020/01/24
 */
public class MyQueue232 {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueue232() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }


    public void push(Integer element) {
        if (null == element) {
            throw new NullPointerException("Element is empty");
        }
        pushStack.push(element);
    }

    public Integer peek() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new NullPointerException("Queue is Empty");
        }
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public Integer pop() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new NullPointerException("Queue is Empty");
        }
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public boolean isEmpty() {
        return popStack.size() + pushStack.size() == 0;
    }
}
