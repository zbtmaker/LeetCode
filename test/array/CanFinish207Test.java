package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/01
 */
public class CanFinish207Test {

    private CanFinish207 canFinish = new CanFinish207();

    @Test
    public void test1() {
        int[][] prerequisites = new int[][]{{1, 0}};
        boolean flag = canFinish.canFinish(2, prerequisites);
        Assert.assertTrue(flag);
    }

    @Test
    public void test2() {
        int[][] prerequisites = new int[][]{{1, 0}, {1, 0}};
        boolean flag = canFinish.canFinish(2, prerequisites);
        Assert.assertFalse(flag);
    }
}
