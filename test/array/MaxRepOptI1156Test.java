package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/04/10
 */
public class MaxRepOptI1156Test extends TestCase {

    private final MaxRepOptI1156 max = new MaxRepOptI1156();

    public void test1() {
        int res = max.maxRepOpt1("aaa");
        Assert.assertEquals(res, 3);
    }

    public void test2() {
        int res = max.maxRepOpt1("acaaabaaa");
        Assert.assertEquals(res, 7);
    }

    public void test3() {
        int res = max.maxRepOpt1("aaabbaaa");
        Assert.assertEquals(res, 4);
    }

    public void test4() {
        int res = max.maxRepOpt1("abcdef");
        Assert.assertEquals(res, 1);
    }

    public void test5() {
        int res = max.maxRepOpt1("aaabaaa");
        Assert.assertEquals(res, 6);
    }

    public void test6() {
        int res = max.maxRepOpt1("aaabaaaca");
        Assert.assertEquals(res, 7);
    }

    public void test7() {
        int res = max.maxRepOpt1("acbaaa");
        Assert.assertEquals(res, 4);
    }

    public void test8() {
        String text = "idhajechdbdbeichdjjddefdjicidieciebcjfcgbfgfabhbejhbediebagjhgjdafiaeiggjhdajejcacecifigbcedeejbgbdi";
        int res = max.maxRepOpt1(text);
        Assert.assertEquals(res, 4);
    }

}
