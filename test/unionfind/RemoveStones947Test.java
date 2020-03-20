package unionfind;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/17
 */
public class RemoveStones947Test {

    private RemoveStones947 remove = new RemoveStones947();

    @Test
    public void test1() {
        int count = remove.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}});
        Assert.assertEquals(count, 5);
    }

    @Test
    public void test2() {
        int count = remove.removeStones(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}});
        Assert.assertEquals(count, 3);
    }

    @Test
    public void test3() {
        int count = remove.removeStones(new int[][]{{0, 0}});
        Assert.assertEquals(count, 0);
    }

    @Test
    public void test4() {
        int count = remove.removeStones(new int[][]{{0, 1}, {1, 0}});
        Assert.assertEquals(count, 0);
    }

    @Test
    public void test5() {
        int count = remove.removeStones(new int[][]{{0, 1}, {1, 0}, {1, 1}});
        Assert.assertEquals(count, 2);
    }
}
