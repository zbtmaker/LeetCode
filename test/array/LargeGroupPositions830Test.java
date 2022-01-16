package array;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

/**
 * @author zoubaitao
 * date 2022/01/16
 */
public class LargeGroupPositions830Test extends TestCase {

    private final LargeGroupPositions830 largeGroup = new LargeGroupPositions830();

    public void test1() {
        List<List<Integer>> lists = largeGroup.largeGroupPositions("abbbaaa");
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

}
