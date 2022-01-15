package array;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

/**
 * @author zoubaitao
 * date 2022/01/15
 */
public class Generate118Test extends TestCase {

    private final Generate118 generate = new Generate118();

    public void test1() {
        int numRows = 5;
        List<List<Integer>> list = generate.generate(5);
        for (int i = 0; i < numRows; i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }
}
