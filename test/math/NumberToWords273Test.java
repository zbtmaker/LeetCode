package math;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/09/10
 */
public class NumberToWords273Test extends TestCase {

    private final NumberToWords273 words = new NumberToWords273();

    public void test1() {
        String res = words.numberToWords(123);
        Assert.assertEquals(res, "One Hundred Twenty Three");
    }

    public void test2() {
        String res = words.numberToWords(12345);
        Assert.assertEquals(res, "Twelve Thousand Three Hundred Forty Five");
    }

    public void test3() {
        String res = words.numberToWords(0);
        Assert.assertEquals(res, "Zero");
    }

    public void test4() {
        String res = words.numberToWords(1);
        Assert.assertEquals(res, "One");
    }
}
