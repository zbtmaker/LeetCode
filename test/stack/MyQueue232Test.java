package stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/24
 */
public class MyQueue232Test {
    private MyQueue232 queue = new MyQueue232();

    @Test
    public void test1(){
        queue.push(1);
        queue.push(2);
        Integer firstElement = queue.peek();
        Assert.assertEquals(firstElement,new Integer(1));
        queue.pop();
        Integer secondElement =  queue.pop();
        Assert.assertEquals(secondElement,new Integer(2));
        Assert.assertEquals(queue.isEmpty(),true);
    }
}
