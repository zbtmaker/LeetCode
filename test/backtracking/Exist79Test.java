package backtracking;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/04/30
 */
public class Exist79Test extends TestCase {

    private Exist79 exist = new Exist79();

    public void test() {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        Assert.assertTrue(exist.exist(board, "ABCCED"));
    }
}
