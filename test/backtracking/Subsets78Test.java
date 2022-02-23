package backtracking;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zoubaitao
 * date 2022/02/23
 */
public class Subsets78Test extends TestCase {
    private final Subsets78 subsets = new Subsets78();

    public void test1() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> sets = subsets.subsets(nums);
        Set<String> set = new HashSet<>();
        for (List<Integer> list : sets) {
            set.add(list.toString());
            System.out.println(Arrays.toString(list.toArray()));
        }
        Assert.assertEquals(set.size(), (int) Math.pow(2, nums.length));
    }
}
