package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/01/16
 */
public class SearchMatrix74Test extends TestCase {
    private final SearchMatrix74 searchMatrix = new SearchMatrix74();

    public void test1() {
        int[][] matrix = new int[][]{{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        boolean result = searchMatrix.searchMatrix(matrix, 7);
        Assert.assertTrue(result);
    }
}
