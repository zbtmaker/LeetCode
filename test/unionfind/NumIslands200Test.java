package unionfind;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/08
 */
public class NumIslands200Test extends TestCase {
    private NumIslands200 islands = new NumIslands200();

    public void test1() {
        int result = islands.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
        Assert.assertEquals(result, 1);
    }

    public void test2() {
        int result = islands.numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}});
        Assert.assertEquals(result, 3);
    }

    public void test3() {
        int result = islands.numIslands(new char[][]{{'0'}});
        Assert.assertEquals(result, 0);
    }

    public void test4() {
        int result = islands.numIslands(new char[][]{{'1'}});
        Assert.assertEquals(result, 1);
    }

    public void test5() {
        int result = islands.numIslands(new char[][]{{'1', '0'}, {'0', '1'}});
        Assert.assertEquals(result, 2);
    }

    public void test6() {
        int result = islands.numIslands(new char[][]{{'1'}, {'1'}});
        Assert.assertEquals(result, 1);
    }
}
