package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/19
 */
public class RemoveDuplicates80Test extends TestCase {

    private final RemoveDuplicates80 removeDuplicates = new RemoveDuplicates80();

    public void test1() {
        int result = removeDuplicates.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
        Assert.assertEquals(result, 5);
    }

}
