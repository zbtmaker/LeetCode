package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/15
 */
public class IsOneBitCharacter717Test extends TestCase {

    private final IsOneBitCharacter717 isOneBitCharacter = new IsOneBitCharacter717();

    public void test1() {
        boolean flag = isOneBitCharacter.isOneBitCharacter(new int[]{1, 0, 0});
        Assert.assertTrue(flag);
    }
}
