package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/04/03
 */
public class ReverseStr541Test extends TestCase {

    private final ReverseStr541 reverse = new ReverseStr541();

    public void test1() {
        String res = reverse.reverseStr("abcdefghi", 2);
        Assert.assertEquals(res, "bacdfeghi");
    }

    public void test3() {
        String res = reverse.reverseStr("abcdefghij", 2);
        Assert.assertEquals(res, "bacdfeghji");
    }

    public void test4() {
        String res = reverse.reverseStr("abcdefghijk", 2);
        Assert.assertEquals(res, "bacdfeghjik");
    }

    public void test5() {
        String res = reverse.reverseStr("abcdefghi", 1);
        Assert.assertEquals(res, "abcdefghi");
    }

    public void test6() {
        String res = reverse.reverseStr("ab", 4);
        Assert.assertEquals(res, "ba");
    }

    public void test7() {
        String res = reverse.reverseStr("abcdefg", 8);
        Assert.assertEquals(res, "gfedcba");
    }

    public void test8() {
        String res = reverse.reverseStr("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39);
        Assert.assertEquals(res, "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi");
    }
}
