package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/04/14
 */
public class MaxVowels1456Test extends TestCase {

    private final MaxVowels1456 max = new MaxVowels1456();

    public void test1() {
        int res = max.maxVowels("abciiidef", 3);
        Assert.assertEquals(res, 3);
    }

    public void test2() {
        int res = max.maxVowels("aaa", 2);
        Assert.assertEquals(res, 2);
    }

    public void test3() {
        int res = max.maxVowels("aaa", 3);
        Assert.assertEquals(res, 3);
    }

    public void test4() {
        int res = max.maxVowels("aeiou", 2);
        Assert.assertEquals(res, 2);
    }

    public void test5() {
        int res = max.maxVowels("leetcode", 3);
        Assert.assertEquals(res, 2);
    }

    public void test6() {
        int res = max.maxVowels("rhythms", 4);
        Assert.assertEquals(res, 0);
    }

    public void test7() {
        int res = max.maxVowels("tryhard", 4);
        Assert.assertEquals(res, 1);
    }
}
