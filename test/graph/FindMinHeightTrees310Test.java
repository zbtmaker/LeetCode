package graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * @author baitao zou
 * date 2020/11/22
 */
public class FindMinHeightTrees310Test {

    private FindMinHeightTrees310 heightTree;

    @Before
    public void before() {
        heightTree = new FindMinHeightTrees310();
    }

    @Test
    public void test1() {
        int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        List<Integer> minHeight = heightTree.findMinHeightTrees(4, edges);
        minHeight.sort(Integer::compareTo);
        Assert.assertArrayEquals(minHeight.toArray(), new Integer[]{1});
    }

    @Test
    public void test2() {
        int[][] edges = new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        List<Integer> minHeight = heightTree.findMinHeightTrees(6, edges);
        minHeight.sort(Integer::compareTo);
        Assert.assertArrayEquals(minHeight.toArray(), new Integer[]{3, 4});
    }

    @Test
    public void test3() {
        int[][] edges = new int[][]{};
        List<Integer> minHeight = heightTree.findMinHeightTrees(1, edges);
        minHeight.sort(Integer::compareTo);
        Assert.assertArrayEquals(minHeight.toArray(), new Integer[]{0});
    }

    @Test
    public void test4() {
        int[][] edges = new int[][]{{0, 1}};
        List<Integer> minHeight = heightTree.findMinHeightTrees(2, edges);
        minHeight.sort(Integer::compareTo);
        Assert.assertArrayEquals(minHeight.toArray(), new Integer[]{0,1});
    }
}
