package backtracking;

import junit.framework.TestCase;

import java.util.List;

/**
 * @author baitao zou
 * date 2020/09/13
 */
public class FindSubsequences491Test extends TestCase {

    private FindSubsequences491 find = new FindSubsequences491();

    public void test1() {
        List<List<Integer>> result = find.findSubsequences(new int[]{4, 6, 7, 7});
        print(result);
    }

    public void test2() {
        List<List<Integer>> result = find.findSubsequences(new int[]{1});
        print(result);
    }

    public void test3() {
        List<List<Integer>> result = find.findSubsequences(new int[]{2, 1});
        print(result);
    }

    public void test4() {
        List<List<Integer>> result = find.findSubsequences(new int[]{});
        print(result);
    }

    public void test5() {
        List<List<Integer>> result = find.findSubsequences(new int[]{1, 2, 3, 1, 1});
        print(result);
    }

    public void test6() {
        List<List<Integer>> result = find.findSubsequences(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1});
        print(result);
    }

    private void print(List<List<Integer>> result) {
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
