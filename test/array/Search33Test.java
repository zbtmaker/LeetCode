package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/09
 */
public class Search33Test {
    private Search33 search = new Search33();

    @Test
    public void test1() {
        int index = search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        Assert.assertEquals(index, 4);
    }

    @Test
    public void test2() {
        int index = search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        Assert.assertEquals(index, -1);
    }

    @Test
    public void test3() {
        int index = search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6);
        Assert.assertEquals(index, 2);
    }

    @Test
    public void test4() {
        int index = search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4);
        Assert.assertEquals(index, 0);
    }

    @Test
    public void test5() {
        int index = search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2);
        Assert.assertEquals(index, 6);
    }

    @Test
    public void test6() {
        int index = search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1);
        Assert.assertEquals(index, 5);
    }

    @Test
    public void test7() {
        int index = search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5);
        Assert.assertEquals(index, 1);
    }

    @Test
    public void test8() {
        int index = search.search(new int[]{1, 0}, 1);
        Assert.assertEquals(index, 0);
    }

    @Test
    public void test9() {
        int index = search.search(new int[]{1, 0}, 0);
        Assert.assertEquals(index, 1);
    }

    @Test
    public void test10() {
        int index = search.search(new int[0],5);
        Assert.assertEquals(index, -1);
    }

    @Test
    public void test11() {
        int index = search.search(new int[]{1},1);
        Assert.assertEquals(index, 0);
    }

    @Test
    public void test12() {
        int index = search.search(new int[]{1,2},1);
        Assert.assertEquals(index, 0);
    }

    @Test
    public void test13() {
        int index = search.search(new int[]{5,1,2},0);
        Assert.assertEquals(index, -1);
    }
}
