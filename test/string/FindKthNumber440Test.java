package string;

import junit.framework.TestCase;
import org.junit.Assert;

public class FindKthNumber440Test extends TestCase {
    private FindKthNumber440 find = new FindKthNumber440();


    public void test1(){
        int result = find.findKthNumber(13,2);
        Assert.assertEquals(result,10);
    }

    public void test2(){
        int result = find.findKthNumber(1000,2);
        Assert.assertEquals(result,10);
    }

    public void test3(){
        int result = find.findKthNumber(10,3);
        Assert.assertEquals(result,2);
    }

    public void test4() {
        int result = find.findKthNumber(10000,10000);
        Assert.assertEquals(result,9999);
    }
}
