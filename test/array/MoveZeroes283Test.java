package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/19
 */
public class MoveZeroes283Test extends TestCase {

    private final MoveZeroes283 moveZero = new MoveZeroes283();

    public void test1() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZero.moveZeroes(nums);
        Assert.assertArrayEquals(nums, new int[]{1, 3, 12, 0, 0});
    }

    public void test2() {
        int[] nums = new int[]{0};
        moveZero.moveZeroes(nums);
        Assert.assertArrayEquals(nums, new int[]{0});
    }
}
