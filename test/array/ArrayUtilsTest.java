package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author baitao zou
 * date 2020/02/04
 */
public class ArrayUtilsTest {
    private ArrayUtils sortArrayUtils = new ArrayUtils();

    @Test
    public void testMergeSort1() {
        int[] arr = new int[]{1, 41, 5, 71, 21, 323, 43};
        sortArrayUtils.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testMergeSort2() {
        int[] arr = new int[]{1};
        sortArrayUtils.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
