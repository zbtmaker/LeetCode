package tree;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/03/12
 */
public class CountHighestScoreNodes2049Test extends TestCase {
    private final CountHighestScoreNodes2049 count = new CountHighestScoreNodes2049();

    public void test1() {
        int result = count.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0});
        Assert.assertEquals(result, 3);
    }

    public void test2() {
        int result = count.countHighestScoreNodes(new int[]{-1, 2, 0});
        Assert.assertEquals(result, 2);
    }
}
