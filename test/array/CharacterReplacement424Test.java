package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/04/16
 */
public class CharacterReplacement424Test extends TestCase {

    private final CharacterReplacement424 replace = new CharacterReplacement424();

    public void test1() {
        int res = replace.characterReplacement("ABAB", 2);
        Assert.assertEquals(res, 4);
    }

    public void test2() {
        int res = replace.characterReplacement("AABABBA", 1);
        Assert.assertEquals(res, 4);
    }

    public void test3() {
        int res = replace.characterReplacement("ABABC", 2);
        Assert.assertEquals(res, 4);
    }

    public void test4() {
        int res = replace.characterReplacement("ABBB", 2);
        Assert.assertEquals(res, 4);
    }

    public void test5() {
        int res = replace.characterReplacement("BAAAB", 2);
        Assert.assertEquals(res, 5);
    }
}
