package backtracking;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author zoubaitao
 * date 2022/02/23
 */
public class Combine77Test extends TestCase {

    private final Combine77 combine = new Combine77();

    public void test1() {
        List<List<Integer>> result = combine.combine(4, 2);
        Assert.assertEquals(result.size(), 6);
    }

    public void test2() {
        List<List<Integer>> result = combine.combine(1, 1);
        Assert.assertEquals(result.size(), 1);
    }
}
