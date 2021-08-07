package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/10/05
 */
public class IsIsomorphic205Test extends TestCase {
    private IsIsomorphic205 isIsomorphic = new IsIsomorphic205();

    public void test1() {
        Assert.assertTrue(isIsomorphic.isIsomorphic("egg", "add"));
    }

    public void test2() {
        Assert.assertFalse(isIsomorphic.isIsomorphic("foo", "bar"));
    }

    public void test3() {
        Assert.assertTrue(isIsomorphic.isIsomorphic("paper", "title"));
    }

    public void test4() {
        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCD";
        String t = "\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\"bcdefg&ijklmnopqrstuvwxyzA@CD";
        Assert.assertTrue(isIsomorphic.isIsomorphic(s, t));
    }
}

