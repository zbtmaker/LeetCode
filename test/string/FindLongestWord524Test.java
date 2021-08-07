package string;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/08/08
 */
public class FindLongestWord524Test extends TestCase {

    private FindLongestWord524 find = new FindLongestWord524();

    public void test1() {
        String result = find.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea"));
        Assert.assertEquals(result, "apple");
    }

    public void test2() {
        String result = find.findLongestWord("abpcplea", Arrays.asList("a", "b", "c"));
        Assert.assertEquals(result, "a");
    }
}
