package backtracking;

import array.CommonUtil;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author zoubaitao
 * date 2022/02/26
 */
public class RestoreIpAddresses93Test extends TestCase {

    private final RestoreIpAddresses93 restore = new RestoreIpAddresses93();

    public void test1() {
        List<String> list = restore.restoreIpAddresses("25525511135");
        Assert.assertArrayEquals(CommonUtil.listToStringArr(list), new String[]{"255.255.11.135", "255.255.111.35"});
    }
}
