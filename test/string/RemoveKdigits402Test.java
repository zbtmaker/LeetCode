package string;

import junit.framework.TestCase;
import org.junit.Assert;

public class RemoveKdigits402Test extends TestCase {

    private RemoveKdigits402 remove = new RemoveKdigits402() ;

    public void test1(){
        String result = remove.removeKdigits("1432219",3);
        Assert.assertEquals(result,"1219");
    }

    public void test2() {
        String result = remove.removeKdigits("10200",1);
        Assert.assertEquals(result,"200");
    }
}
