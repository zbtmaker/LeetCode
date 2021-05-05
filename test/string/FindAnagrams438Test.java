package string;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author Baitao Zou
 * date 2021/05/05
 */
public class FindAnagrams438Test extends TestCase {
    private FindAnagrams438 find = new FindAnagrams438();

    public void test1() {
        List<Integer> result = find.findAnagrams("cbaebabacd", "abc");
        Assert.assertArrayEquals(result.toArray(new Integer[0]), new Integer[]{0, 6});
    }

    public void test2() {
        List<Integer> result = find.findAnagrams("abab", "ab");
        Assert.assertArrayEquals(result.toArray(new Integer[0]), new Integer[]{0, 1, 2});
    }

    public void test3() {
        List<Integer> result = find.findAnagrams("abacbabc", "abc");
        Assert.assertArrayEquals(result.toArray(new Integer[0]), new Integer[]{1, 2, 3, 5});
    }

    public void test4() {
        List<Integer> result = find.findAnagrams("abaacbabc", "abc");
        Assert.assertArrayEquals(result.toArray(new Integer[0]), new Integer[]{3, 4, 6});
    }

    public void test5() {
        List<Integer> result = find.findAnagrams("vwwvv", "vwv");
        Assert.assertArrayEquals(result.toArray(new Integer[0]), new Integer[]{2});
    }
}
