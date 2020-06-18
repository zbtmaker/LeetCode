package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/06/14
 */
public class FrequencySort451Test extends TestCase {
    private FrequencySort451 sort = new FrequencySort451();

    public void test1() {
        String s = sort.frequencySort("tree");
        Assert.assertEquals(s, "eert");
    }
}
