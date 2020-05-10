package design;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author baitao zou
 * date 2020/05/10
 */
public class MyStack225Test {

    private MyStack225 myStack = new MyStack225();

    @Test
    public void test1() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);
        queue.addLast(2);
        Assert.assertEquals(queue.peekLast(), new Integer(2));
    }
}
