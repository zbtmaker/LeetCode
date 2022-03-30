package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/03/30
 */
public class MaximalSquare221Test extends TestCase {

    private final MaximalSquare221 max = new MaximalSquare221();

    public void test1() {
        int res = max.maximalSquare(new char[][]{
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'},});
        Assert.assertEquals(res, 9);
    }

    public void test2() {
        int res = max.maximalSquare(new char[][]{
                {'0'}});
        Assert.assertEquals(res, 0);
    }

    public void test3() {
        int res = max.maximalSquare(new char[][]{
                {'1'}});
        Assert.assertEquals(res, 1);
    }

    public void test4() {
        int res = max.maximalSquare(new char[][]{
                {'0', '1'},
                {'1', '0'}});
        Assert.assertEquals(res, 1);
    }
}
