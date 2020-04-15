package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/15
 */
public class MinCut132Test {

    private MinCut132 minCut = new MinCut132();

    @Test
    public void test1() {
        int min = minCut.minCut("aba");
        Assert.assertEquals(min, 0);
    }

    @Test
    public void test2() {
        int min = minCut.minCut("aab");
        Assert.assertEquals(min, 1);
    }

    @Test
    public void test3(){
        int min = minCut.minCut("aababab");
        Assert.assertEquals(min, 1);
    }

    @Test
    public void test4(){
        int min = minCut.minCut("a");
        Assert.assertEquals(min, 0);
    }


    @Test
    public void test5(){
        int min = minCut.minCut("aa");
        Assert.assertEquals(min, 0);
    }

    @Test
    public void test6(){
        int min = minCut.minCut("ab");
        Assert.assertEquals(min, 1);
    }

    @Test
    public void test7(){
        int min = minCut.minCut("cabababcbc");
        Assert.assertEquals(min, 3);
    }
}
