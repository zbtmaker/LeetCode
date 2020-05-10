package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/10
 */
public class OriginalDigits423Test {

    private OriginalDigits423 original = new OriginalDigits423();

    @Test
    public void test1() {
        String digits = original.originalDigits("owoztneoer");
        Assert.assertEquals(digits, "012");
    }

    @Test
    public void test2() {
        String digits = original.originalDigits("fviefuro");
        Assert.assertEquals(digits, "45");
    }

    @Test
    public void test3() {
        String digits = original.originalDigits("");
        Assert.assertEquals(digits, "");
    }
}
