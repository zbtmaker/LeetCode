package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/02
 */
public class Trie208Test {

    @Test
    public void test1() {
        Trie208 trie = new Trie208();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));
        Assert.assertFalse(trie.search("app"));
        Assert.assertTrue(trie.startWith("app"));
        trie.insert("appstore");
        Assert.assertTrue(trie.startWith("apps"));

        Assert.assertTrue(trie.startWith("a"));
    }
}
