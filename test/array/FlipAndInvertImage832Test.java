package array;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author zoubaitao
 * date 2022/01/15
 */
public class FlipAndInvertImage832Test extends TestCase {
    private FlipAndInvertImage832 flip = new FlipAndInvertImage832();

    public void test1() {
        int[][] A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flip.flipAndInvertImage(A);
        for (int[] ints : A) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
