package unionfind;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/08
 */
public class NumIslands200Test {
    private NumIslands200 islands = new NumIslands200();

    @Test
    public void test1() {
        int result = islands.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
        Assert.assertEquals(result, 1);
    }

    @Test
    public void test2() {
        int result = islands.numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}});
        Assert.assertEquals(result, 3);
    }

    @Test
    public void test3() {
        int result = islands.numIslands(new char[][]{{'0'}});
        Assert.assertEquals(result, 0);
    }

    @Test
    public void test4() {
        int result = islands.numIslands(new char[][]{{'1'}});
        Assert.assertEquals(result, 1);
    }

    @Test
    public void test5() {
        int result = islands.numIslands(new char[][]{{'1', '0'}, {'0', '1'}});
        Assert.assertEquals(result, 2);
    }
}
