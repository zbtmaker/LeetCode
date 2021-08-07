package array;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/06/14
 */
public class KSmallestPairs373Test extends TestCase {
    private KSmallestPairs373 small = new KSmallestPairs373();

    public void test1() {
        List<List<Integer>> result = small.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        print(result);
    }

    public void test2() {
        List<List<Integer>> result = small.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);
        print(result);
    }

    public void test3() {
        List<List<Integer>> result = small.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3);
        print(result);
    }

    public void test4() {
        List<List<Integer>> result = small.kSmallestPairs(new int[]{}, new int[]{}, 3);
        print(result);
    }

    public void print(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray(new Integer[0])));
        }
    }


}
