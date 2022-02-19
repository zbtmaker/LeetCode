package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/19
 */
public class RemoveElements26Test extends TestCase {

    private final RemoveElements26 remove = new RemoveElements26();

    public void test1() {
        int result = remove.removeElement(new int[]{1, 1, 2});
        Assert.assertEquals(result, 2);
    }
}
