package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/04/27
 */
public class RemoveDuplicateLetters316Test extends TestCase {

    private RemoveDuplicateLetters316 remove = new RemoveDuplicateLetters316();

    public void test1() {
        String s = remove.removeDuplicateLetters("bcabc");
        Assert.assertEquals(s, "abc");
    }

    public void test2() {
        String s = remove.removeDuplicateLetters("cbacdcbc");
        Assert.assertEquals(s,"acdb");
    }
}
