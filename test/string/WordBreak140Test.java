package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/04/24
 */
public class WordBreak140Test {
    private WordBreak140 wordBreak = new WordBreak140();

    @Test
    public void test1() {
        List<String> result = wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code"));
        Assert.assertArrayEquals(result.toArray(new String[0]), new String[]{"leet code"});
    }

    @Test
    public void test2() {
        List<String> result = wordBreak.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        Assert.assertArrayEquals(result.toArray(new String[0]), new String[]{"pine apple pen apple",
                "pineapple pen apple",
                "pine applepen apple"});
    }

    @Test
    public void test3() {
        List<String> result = wordBreak.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        Assert.assertArrayEquals(result.toArray(new String[0]), new String[0]);
    }

    @Test
    public void test4() {
        List<String> result = wordBreak.wordBreak("catsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        Assert.assertArrayEquals(result.toArray(new String[0]), new String[]{"cat sand dog", "cats and dog"});
    }
}
