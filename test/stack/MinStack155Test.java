package stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/28
 */
public class MinStack155Test {
    private MinStack155 minStack = new MinStack155();

    @Test
    public void test1() {
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(minStack.getMin(), -3);

        minStack.pop();
        Assert.assertEquals(minStack.top(), 0);
        minStack.pop();
        Assert.assertEquals(minStack.getMin(),-2);
    }
}
