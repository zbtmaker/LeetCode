package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/03/17
 */
public class LongestWord720Test extends TestCase {

    private LongestWord720 longest = new LongestWord720();

    public void test1() {
        String str = longest.longestWord(new String[]{"w", "wo", "wor", "worl", "world"});
        Assert.assertEquals(str, "world");
    }

    public void test2() {
        String str = longest.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});
        Assert.assertEquals(str, "apple");
    }

    public void test3() {
        String str = longest.longestWord(new String[]{"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"});
        Assert.assertEquals(str, "latte");
    }

    public void test4() {
        String str = longest.longestWord(new String[]{"l", "le", "lel", "lelelele"});
        Assert.assertEquals(str, "lel");
    }

    public void test5() {
        String str = longest.longestWord(new String[]{"wo", "wor", "worl", "world"});
        Assert.assertEquals(str, "");
    }
}
