package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/12
 */
public class NumSimilarGroups839Test {

    private NumSimilarGroups839 group = new NumSimilarGroups839();

    @Test
    public void test1() {
        int result = group.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"});
        Assert.assertEquals(result, 2);
    }

    @Test
    public void test2() {
        int result = group.numSimilarGroups(new String[]{"blw","bwl","wlb"});
        Assert.assertEquals(result, 1);
    }

    @Test
    public void test3() {
        int result = group.numSimilarGroups(new String[]{"abc","abc"});
        Assert.assertEquals(result, 1);
    }
}
