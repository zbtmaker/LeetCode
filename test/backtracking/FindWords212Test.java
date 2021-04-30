package backtracking;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author Baitao Zou
 * date 2021/04/30
 */
public class FindWords212Test extends TestCase {
    private FindWords212 find = new FindWords212();

    public void test1() {
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        List<String> list = find.findWords(board, words);
        Assert.assertArrayEquals(list.toArray(new String[0]), new String[]{"oath", "eat"});
    }

    public void test2() {
        char[][] board = new char[][]{{'a'}};
        String[] words = new String[]{"ab"};
        List<String> list = find.findWords(board, words);
        Assert.assertEquals(list.toArray(new String[0]), new String[0]);
    }
}
