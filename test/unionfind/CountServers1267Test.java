package unionfind;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/09
 */
public class CountServers1267Test {
    private CountServers1267 servers = new CountServers1267();

    @Test
    public void test1() {
        int count = servers.countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}});
        Assert.assertEquals(count, 4);
    }

    @Test
    public void test2() {
        int count = servers.countServers(new int[][]{{1, 1}, {0, 1}});
        Assert.assertEquals(count, 3);
    }

    @Test
    public void test3() {
        int count = servers.countServers(new int[][]{{1,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0}});
        Assert.assertEquals(count, 0);
    }

}
