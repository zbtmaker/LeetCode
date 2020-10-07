package design;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/10/03
 */
public class WordDictionary211Test extends TestCase {

    private WordDictionary211 wordDictionary = new WordDictionary211();

    public void test1() {
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assert.assertFalse(wordDictionary.search("pad")); // return False
        Assert.assertTrue(wordDictionary.search("bad")); // return True
        Assert.assertTrue(wordDictionary.search(".ad")); // return True
        Assert.assertTrue(wordDictionary.search("b..")); // return True
    }

    public void test2() {
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        Assert.assertTrue(wordDictionary.search("."));
        Assert.assertTrue(wordDictionary.search("a"));
        Assert.assertFalse(wordDictionary.search("aa"));
        Assert.assertTrue(wordDictionary.search("a"));
        Assert.assertFalse(wordDictionary.search(".a"));
        Assert.assertFalse(wordDictionary.search("a."));
    }

    public void test3() {
        wordDictionary.addWord("a");
        wordDictionary.addWord("ab");
        Assert.assertTrue(wordDictionary.search("a"));
        Assert.assertTrue(wordDictionary.search("a."));
        Assert.assertTrue(wordDictionary.search("ab"));
        Assert.assertFalse(wordDictionary.search(".a"));
        Assert.assertTrue(wordDictionary.search(".b"));
        Assert.assertFalse(wordDictionary.search("ab."));
        Assert.assertTrue(wordDictionary.search("."));
        Assert.assertTrue(wordDictionary.search(".."));
    }

    public void test4() {
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        Assert.assertFalse(wordDictionary.search("a"));
        Assert.assertFalse(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        Assert.assertTrue(wordDictionary.search(".at"));
        Assert.assertTrue(wordDictionary.search("an."));
        Assert.assertFalse(wordDictionary.search("a.d."));
        Assert.assertFalse(wordDictionary.search("b."));
        Assert.assertTrue(wordDictionary.search("a.d"));
        Assert.assertFalse(wordDictionary.search("."));
    }
}
