package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/17
 */
public class KnightProbability688Test extends TestCase {

    private final KnightProbability688 knight = new KnightProbability688();

    public void test1() {
        double result = knight.knightProbability(3, 2, 0, 0);
        Assert.assertEquals(String.valueOf(result), "0.0625");
    }

    public void test2() {
        double result = knight.knightProbability(1, 0, 0, 0);
        Assert.assertEquals(String.valueOf(result), "1.0");
    }

    public void test3() {
        double result = knight.knightProbability(8, 30, 6, 4);

        Assert.assertEquals(String.valueOf(result), "0.00019");
    }
}
