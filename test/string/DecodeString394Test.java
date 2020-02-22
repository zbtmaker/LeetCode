package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/21
 */
public class DecodeString394Test {
    private DecodeString394 decode = new DecodeString394();

    @Test
    public void test1() {
        String result = decode.decodeString("3[a]2[bc]");
        Assert.assertEquals(result, "aaabcbc");
    }

    @Test
    public void test2() {
        String result = decode.decodeString("3[a2[c]]");
        Assert.assertEquals(result, "accaccacc");
    }

    @Test
    public void test3() {
        String result = decode.decodeString("2[abc]3[cd]ef");
        Assert.assertEquals(result, "abcabccdcdcdef");
    }

    @Test
    public void test4() {
        String result = decode.decodeString("2[abc3[cd]ef]");
        Assert.assertEquals(result, "abccdcdcdefabccdcdcdef");
    }

    @Test
    public void test5() {
        String result = decode.decodeString("2[abc]ef3[cd]");
        Assert.assertEquals(result, "abcabcefcdcdcd");
    }

    @Test
    public void test6() {
        String result = decode.decodeString("2[2[abc]ef3[cd]]");
        Assert.assertEquals(result, "abcabcefcdcdcdabcabcefcdcdcd");
    }

    @Test
    public void test7() {
        String result = decode.decodeString("abc2[efg]");
        Assert.assertEquals(result, "abcefgefg");
    }

    @Test
    public void test8() {
        String result = decode.decodeString("2[2[cd2[ef]]gh]");
        Assert.assertEquals(result, "cdefefcdefefghcdefefcdefefgh");
    }

    @Test
    public void test9() {
        String result = decode.decodeString("");
        Assert.assertEquals(result, "");
    }

    @Test
    public void test10() {
        String result = decode.decodeString(null);
        Assert.assertEquals(result, null);
    }

    @Test
    public void test11() {
        String result = decode.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
        Assert.assertEquals(result, "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef");
    }
}
