package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/03/09
 */
public class ValidIPAddress468Test extends TestCase {
    private final ValidIPAddress468 valid = new ValidIPAddress468();

    public void test1() {
        String result = valid.validIPAddress("172.16.254.1");
        Assert.assertEquals(result, "IPv4");
    }

    public void test2() {
        String result = valid.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334");
        Assert.assertEquals(result, "IPv6");
    }

    public void test3() {
        String result = valid.validIPAddress("256.256.256.256");
        Assert.assertEquals(result, "Neither");
    }

    public void test4() {
        String result = valid.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
        Assert.assertEquals(result, "Neither");
    }

    public void test5() {
        String result = valid.validIPAddress("12..33.4");
        Assert.assertEquals(result, "Neither");
    }

    public void test6() {
        String result = valid.validIPAddress("2001:0db8:85a3::0:8A2E:0370:7334");
        Assert.assertEquals(result, "Neither");
    }
}
