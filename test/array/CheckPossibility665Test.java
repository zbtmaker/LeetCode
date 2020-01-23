package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/19
 */
public class CheckPossibility665Test {

    private CheckPossibility665 check = new CheckPossibility665();
    @Test
    public void test1(){
        boolean flag = check.checkPossibility(new int[]{4,2,3});
        Assert.assertEquals(flag,true);
    }

    @Test
    public void test2(){
        boolean flag = check.checkPossibility(new int[]{2,2,1});
        Assert.assertEquals(flag,true);
    }

    @Test
    public void test3(){
        boolean flag = check.checkPossibility(new int[]{2,2,1,1});
        Assert.assertEquals(flag,false);
    }
}
