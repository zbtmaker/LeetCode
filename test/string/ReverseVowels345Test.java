package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/27
 */
public class ReverseVowels345Test {
    private ReverseVowels345 vowels = new ReverseVowels345();

    @Test
    public void test1() {
        String result = vowels.reverseVowels("hello");
        Assert.assertEquals(result, "holle");
    }

    @Test
    public void test2() {
        String result = vowels.reverseVowels("leetcode");
        Assert.assertEquals(result, "leotcede");
    }

    @Test
    public void test3() {
        String result = vowels.reverseVowels("o");
        Assert.assertEquals(result, "o");
    }

    @Test
    public void test4() {
        String result = vowels.reverseVowels("oq");
        Assert.assertEquals(result, "oq");
    }

    @Test
    public void test5() {
        String result = vowels.reverseVowels("oqi");
        Assert.assertEquals(result, "iqo");
    }

    @Test
    public void test6() {
        String result = vowels.reverseVowels("aO");
        Assert.assertEquals(result, "Oa");
    }

    @Test
    public void test7() {
        String result = vowels.reverseVowels("Anne, I vote more cars race Rome-to-Vienna.");
        Assert.assertEquals(result, "anne, i vote more cars race Rome-to-VIennA.");
    }
}
