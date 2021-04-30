package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/03/22
 */
public class AddString415Test extends TestCase {
    private AddStrings415 add = new AddStrings415();

    public void test1() {
        String result = add.addString("212", "1");
        Assert.assertEquals(result, "213");
    }

    public void test2() {
        String result = add.addString("86270130072", "44843256576111");
        Assert.assertEquals(result, "44929526706183");
    }
}
