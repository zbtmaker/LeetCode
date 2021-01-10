package string;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author Baitao Zou
 * date 2021/01/10
 */
public class TestFindSubstring30 extends TestCase {

    private FindSubstring30 find = new FindSubstring30();

    public void test1() {
        List<Integer> index = find.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        Assert.assertArrayEquals(index.toArray(new Integer[0]), new Integer[]{0, 9});
    }

    public void test2() {
        List<Integer> index = find.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});
        Assert.assertArrayEquals(index.toArray(new Integer[0]), new Integer[]{});
    }

}
