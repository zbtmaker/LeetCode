package design;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/05
 */
public class RandomizedCollection381Test {
    private RandomizedCollection381 random = new RandomizedCollection381();

    @Test
    public void test1() {
        Assert.assertTrue(random.insert(1));
        Assert.assertTrue(random.insert(2));
        Assert.assertFalse(random.insert(1));
        Assert.assertTrue(random.remove(1));
        Assert.assertFalse(random.remove(3));
    }
}
