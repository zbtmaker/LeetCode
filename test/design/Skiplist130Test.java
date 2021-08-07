package design;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/08/02
 */
public class Skiplist130Test extends TestCase {

    public void test1() {
        Skiplist130 skiplist130 = new Skiplist130();
        skiplist130.add(1);
        skiplist130.add(2);
        skiplist130.add(3);
        Assert.assertFalse(skiplist130.search(0));

        skiplist130.add(4);
        Assert.assertTrue(skiplist130.search(1));

        Assert.assertFalse(skiplist130.erase(0));
        Assert.assertTrue(skiplist130.erase(1));
        Assert.assertFalse(skiplist130.search(1));
    }
}
