package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/04/24
 */
public class WordBreak139Test {
    private WordBreak139 wordBreak = new WordBreak139();

    @Test
    public void test1() {
        boolean flag = wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code"));
        Assert.assertTrue(flag);
    }

    @Test
    public void test2() {
        boolean flag = wordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen"));
        Assert.assertTrue(flag);
    }

    @Test
    public void test3() {
        boolean flag = wordBreak.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        Assert.assertFalse(flag);
    }

    @Test
    public void test4() {
        boolean flag = wordBreak.wordBreak("catsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        Assert.assertTrue(flag);
    }
}
