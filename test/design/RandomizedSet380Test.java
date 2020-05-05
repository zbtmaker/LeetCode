package design;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/05
 */
public class RandomizedSet380Test {

    private RandomizedSet380 random = new RandomizedSet380();

    @Test
    public void test1() {
        Assert.assertTrue(random.insert(1));
        Assert.assertFalse(random.remove(2));
        Assert.assertEquals(random.getRandom(), 1);
        Assert.assertTrue(random.insert(2));
        random.getRandom();
    }


    @Test
    public void test2() {
        Assert.assertTrue(random.insert(1));
        Assert.assertTrue(random.insert(2));
        Assert.assertTrue(random.insert(3));
        System.out.println(random.getRandom());
        System.out.println(random.getRandom());
        System.out.println(random.getRandom());
        System.out.println(random.getRandom());
        System.out.println(random.getRandom());
        System.out.println(random.getRandom());

    }
}
