package string;

import org.junit.Assert;
import org.junit.Test;

public class CountAndSayTest {
    private CountAndSay38 countAndSay = new CountAndSay38();

    /**
     * 测试用例I：1
     */
    @Test
    public void test1(){
        int n = 1;
        String str = countAndSay.countAndSay(n);
        Assert.assertEquals(str,"1");
    }

    @Test
    public void test2(){
        int n = 2;
        String str = countAndSay.countAndSay(n);
        Assert.assertEquals(str,"11");
    }

    @Test
    public void test3(){
        int n = 3;
        String str = countAndSay.countAndSay(n);
        Assert.assertEquals(str,"21");
    }

    @Test
    public void test4(){
        int n = 4;
        String str = countAndSay.countAndSay(n);
        Assert.assertEquals(str,"1211");
    }

    @Test
    public void test5(){
        int n = 5;
        String str = countAndSay.countAndSay(n);
        Assert.assertEquals(str,"111221");
    }
}
