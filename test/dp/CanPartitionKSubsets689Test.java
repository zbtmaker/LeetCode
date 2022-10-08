package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/10/07
 */
public class CanPartitionKSubsets689Test extends TestCase {

    private final CanPartitionKSubsets689 partition = new CanPartitionKSubsets689();

    public void test1() {
        boolean res = partition.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
        Assert.assertTrue(res);
    }

    public void test2() {
        boolean res = partition.canPartitionKSubsets(new int[]{4, 4, 6, 2, 3, 8, 10, 2, 10, 7}, 4);
        Assert.assertTrue(res);
    }

}
