package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/21
 */
public class PushDominoes838Test extends TestCase {

    private final PushDominoes838 dominoes = new PushDominoes838();

    public void test1() {
        String result = dominoes.pushDominoes("RR.L");
        Assert.assertEquals(result, "RR.L");
    }

    public void test2() {
        String result = dominoes.pushDominoes(".L.R...LR..L..");
        Assert.assertEquals(result, "LL.RR.LLRRLL..");
    }
}
