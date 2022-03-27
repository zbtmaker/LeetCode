package design;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/03/27
 */
public class SkipLists1206Test extends TestCase {

    public void test1() {
        SkipLists1206 skipLists = new SkipLists1206();
        skipLists.add(1);
        skipLists.add(2);
        skipLists.add(3);
        Assert.assertFalse(skipLists.search(0));
        skipLists.add(4);
        Assert.assertTrue(skipLists.search(1));
        Assert.assertFalse(skipLists.erase(0));
        Assert.assertTrue(skipLists.erase(1));
        Assert.assertFalse(skipLists.search(1));
    }

    public void test2() {
        SkipLists1206 skipLists = new SkipLists1206();
        for (int i = 0; i < 16; i++) {
            Assert.assertFalse(skipLists.search(i));
            skipLists.add(i);
            Assert.assertTrue(skipLists.search(i));
        }
        for (int i = 0; i < 16; i++) {
            Assert.assertTrue(skipLists.erase(i));
        }
        for (int i = 0; i < 16; i++) {
            Assert.assertFalse(skipLists.search(i));
        }
    }

    public void test3() {
        for (int i = 0; i < 10000; i++) {
            test2();
        }
    }
}
