package design;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * @author baitao zou
 * date 2020/05/10
 */
public class MyStack225 {
    /**
     * 这里我们需要做的就是用一个firQueue来保存push操作的数据,这个queue表示后进入的数据。而secQueue表示
     * 先进入的数据，那么如果我们执行pop操作或者是top操作的时候，因为执行pop操作和top操作都是要对取最后进来的数据。
     * 因为firQueue永远记录后进来的数据，所以，执行pop操作时，如果firQueue不为空，我们知道最后一个pop的元素其实就是我们
     * 需要的栈顶的元素。如果firQueue.isEmpty=true，表示没有后进来的数据，此时所有先进来的数据都保存到secQueue队列了。
     * 此时我们就需要对secQueue队列执行pop操作，最后一次执行pop的元素就是栈顶元素。
     */
    private final Queue<Integer> firQueue;
    private final Queue<Integer> secQueue;

    /**
     * Initialize your data structure here.
     */
    public MyStack225() {
        firQueue = new ArrayDeque<>();
        secQueue = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        firQueue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (!firQueue.isEmpty() || !secQueue.isEmpty()) {
            if (!firQueue.isEmpty()) {
                int size = firQueue.size();
                while (!firQueue.isEmpty()) {
                    if (size == 1) {
                        return firQueue.poll();
                    }
                    secQueue.add(firQueue.poll());
                    size--;
                }
            } else {
                int size = secQueue.size();
                while (!secQueue.isEmpty()) {
                    if (size == 1) {
                        return secQueue.poll();
                    }
                    firQueue.add(secQueue.poll());
                    size--;
                }
            }
        }
        return -1;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (!firQueue.isEmpty() || !secQueue.isEmpty()) {
            int size = firQueue.isEmpty() ? secQueue.size() : firQueue.size();
            if (!firQueue.isEmpty()) {
                while (!firQueue.isEmpty()) {
                    if (size == 1) {
                        int last = firQueue.poll();
                        secQueue.add(last);
                        return last;
                    }
                    secQueue.add(firQueue.poll());
                    size--;
                }
            } else {
                while (!secQueue.isEmpty()) {
                    if (size == 1) {
                        int last = secQueue.poll();
                        firQueue.add(last);
                        return last;
                    }
                    firQueue.add(secQueue.poll());
                    size--;
                }
            }
        }
        return -1;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return firQueue.isEmpty() && secQueue.isEmpty();
    }
}
