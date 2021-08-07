package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2020/12/27
 */
public class WinnerSquareGame1510Test extends TestCase {

    private WinnerSquareGame1510 winner = new WinnerSquareGame1510();

    public void test1() {
        boolean result = winner.winnerSquareGame(1);
        Assert.assertTrue(result);
    }

    public void test2() {
        boolean result = winner.winnerSquareGame(2);
        Assert.assertFalse(result);
    }

    public void test3() {
        boolean result = winner.winnerSquareGame(3);
        Assert.assertTrue(result);
    }

    public void test4() {
        boolean result = winner.winnerSquareGame(4);
        Assert.assertTrue(result);
    }
}
