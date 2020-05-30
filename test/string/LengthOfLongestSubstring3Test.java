package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/05/30
 */
public class LengthOfLongestSubstring3Test extends TestCase {
    private LengthOfLongestSubstring3 longestSubstring = new LengthOfLongestSubstring3();

    public void test1() {
        int len = longestSubstring.lengthOfLongestSubstring("abcabcbb");
        Assert.assertEquals(len, 3);
    }

    public void test2() {
        int len = longestSubstring.lengthOfLongestSubstring("bbbbb");
        Assert.assertEquals(len, 1);
    }

    public void test3() {
        int len = longestSubstring.lengthOfLongestSubstring("pwwkew");
        Assert.assertEquals(len, 3);
    }

    public void test4() {
        int len = longestSubstring.lengthOfLongestSubstring("p");
        Assert.assertEquals(len, 1);
    }
}
