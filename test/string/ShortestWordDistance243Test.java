package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/11/28
 */
public class ShortestWordDistance243Test extends TestCase {
    private ShortestWordDistance243 shortest = new ShortestWordDistance243();

    public void test1() {
        int dis = shortest.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice");
        Assert.assertEquals(dis, 3);
    }


    public void test2() {
        int dis = shortest.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "makes");
        Assert.assertEquals(dis, 1);
    }
}
