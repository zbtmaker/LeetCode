package unionfind;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/09
 */
public class MakeConnected1319Test {

    private MakeConnected1319 make = new MakeConnected1319();

    @Test
    public void test1() {
        int result = make.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}});
        Assert.assertEquals(result, 2);
    }

    @Test
    public void test2() {
        int result = make.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}});
        Assert.assertEquals(result, -1);
    }

    @Test
    public void test3() {
        int result = make.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}});
        Assert.assertEquals(result, -1);
    }

    @Test
    public void test4() {
        int result = make.makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}});
        Assert.assertEquals(result, 0);
    }

    @Test
    public void test5() {
        int result = make.makeConnected(12, new int[][]{{1, 5}, {1, 7}, {1, 2}, {1, 4}, {3, 7}, {4, 7}, {3, 5}, {0, 6}, {0, 1}, {0, 4}, {2, 6}, {0, 3}, {0, 2}});
        Assert.assertEquals(result, 4);
    }

}
