package array;

import junit.framework.TestCase;
import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/02/04
 */
public class ArrayUtilsTest extends TestCase {
    private ArrayUtils sortArrayUtils = new ArrayUtils();

    public void testMergeSort1() {
        int[] arr = new int[]{1, 41, 5, 71, 21, 323, 43};
        sortArrayUtils.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void testMergeSort2() {
        int[] arr = new int[]{1};
        sortArrayUtils.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
