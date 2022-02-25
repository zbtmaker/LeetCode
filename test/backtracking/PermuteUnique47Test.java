package backtracking;

import junit.framework.TestCase;

import java.util.List;

/**
 * @author zoubaitao
 * date 2022/02/24
 */
public class PermuteUnique47Test extends TestCase {

    private final PermuteUnique47 permute = new PermuteUnique47();

    public void test1() {
        int[] nums = new int[]{0, 0, 0, 1, 9};
        List<List<Integer>> result = permute.permuteUnique(nums);
    }

    public void test2() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = permute.permuteUnique(nums);
    }
}
