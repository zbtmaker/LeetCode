package backtracking;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author zoubaitao
 * date 2022/02/23
 */
public class CombinationSumIII216Test extends TestCase {

    private final CombinationSumIII216 combine = new CombinationSumIII216();

    public void test1() {
        List<List<Integer>> result = combine.combinationSum3(3, 7);
        Assert.assertEquals(result.size(), 1);
    }

    public void test2() {
        List<List<Integer>> result = combine.combinationSum3(3, 9);
        Assert.assertEquals(result.size(), 3);
    }
}
