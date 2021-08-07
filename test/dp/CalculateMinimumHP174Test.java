package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/14
 */
public class CalculateMinimumHP174Test {
    private CalculateMinimumHP174 minHP = new CalculateMinimumHP174();

    @Test
    public void test1() {
        int min = minHP.calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        });
        Assert.assertEquals(min, 7);
    }

    @Test
    public void test2() {
        int min = minHP.calculateMinimumHP(new int[][]{
                {0},
        });
        Assert.assertEquals(min, 1);
    }

    @Test
    public void test3() {
        int min = minHP.calculateMinimumHP(new int[][]{
                {-1},
        });
        Assert.assertEquals(min, 2);
    }

    @Test
    public void test4() {
        int min = minHP.calculateMinimumHP(new int[][]{
                {1},
        });
        Assert.assertEquals(min, 1);
    }
}
