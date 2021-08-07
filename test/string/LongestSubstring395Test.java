package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/10/06
 */
public class LongestSubstring395Test extends TestCase {

    private LongestSubstring395 longestSubstring = new LongestSubstring395();

    public void test1() {
        int result = longestSubstring.longestSubstring("aaabb", 3);
        Assert.assertEquals(result, 3);
    }

    public void test2() {
        int result = longestSubstring.longestSubstring("ababbc", 2);
        Assert.assertEquals(result, 5);
    }

    public void test3() {
        int result = longestSubstring.longestSubstring("bbaaacbd", 3);
        Assert.assertEquals(result, 3);
    }
}
