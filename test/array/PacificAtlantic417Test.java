package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/04/05
 */
public class PacificAtlantic417Test {

    public PacificAtlantic417 pacific = new PacificAtlantic417();

    @Test
    public void test1() {
        List<List<Integer>> result = pacific.pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        });
        for (List<Integer> arr : result) {
            System.out.println(Arrays.toString(arr.toArray(new Integer[0])));
        }
    }
}
