package array;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author Baitao Zou
 * date 2021/02/25
 */
public class SearchMatrix240Test extends TestCase {
    private SearchMatrix240 search = new SearchMatrix240();

    public void test1(){
        boolean flag  =search.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5);
        Assert.assertTrue(flag);

    }
}
