package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/03/21
 */
public class TestStockSpanner901 extends TestCase {

    public void test1() {
        StockSpanner901 stock = new StockSpanner901();
        Assert.assertEquals(stock.next(100), 1);
        Assert.assertEquals(stock.next(80), 1);
        Assert.assertEquals(stock.next(60), 1);
        Assert.assertEquals(stock.next(70), 2);
        Assert.assertEquals(stock.next(60), 1);
        Assert.assertEquals(stock.next(75), 4);
        Assert.assertEquals(stock.next(85), 6);
    }
}
