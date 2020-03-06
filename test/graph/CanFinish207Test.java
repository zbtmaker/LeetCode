package graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/06
 */
public class CanFinish207Test {

    private CanFinish207 finish = new CanFinish207();

    @Test
    public void test1() {
        boolean flag = finish.canFinish(2, new int[][]{{1, 0}});
        Assert.assertTrue(flag);
    }

    @Test
    public void test2() {
        boolean flag = finish.canFinish(2, new int[][]{{1, 0}, {0, 1}});
        Assert.assertFalse(flag);
    }

    @Test
    public void test3() {
        boolean flag = finish.canFinish(3, new int[][]{{0, 1}, {0, 2}, {1, 2}});
        Assert.assertTrue(flag);
    }

}
