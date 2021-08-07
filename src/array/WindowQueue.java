package array;

import java.util.ArrayDeque;

/**
 * @author Baitao Zou
 * date 2021/03/12
 */
public class WindowQueue {
    private ArrayDeque<Integer> queue;

    public WindowQueue() {
        queue = new ArrayDeque<>();
    }

    public void push(int e) {
        while (!queue.isEmpty() && queue.peekLast() < e) {
            queue.pollLast();
        }
        queue.addLast(e);
    }

    public int max() {
        if (queue.isEmpty()) {
            throw new NullPointerException();
        }
        return queue.peekFirst();
    }

    public void poll() {
        queue.pollFirst();
    }
}
