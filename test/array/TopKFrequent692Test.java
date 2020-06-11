package array;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author baitao zou
 * date 2020/06/11
 */
public class TopKFrequent692Test extends TestCase {

    private TopKFrequent692 top = new TopKFrequent692();

    public void test1() {
        List<String> result = top.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        Assert.assertArrayEquals(result.toArray(new String[0]), new String[]{"i", "love"});
    }
}
