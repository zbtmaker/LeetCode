package math;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2021/08/{DAY}
 */
public class AddDigits258Test extends TestCase {

    public final AddDigits258 add = new AddDigits258();

    public void test1() {
        int result = add.addDigits(38);
        Assert.assertEquals(result, 2);
    }
}
