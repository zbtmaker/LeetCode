package array;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/07/05
 */
public class FindMedianSortedArrays4Test extends TestCase {
    private FindMedianSortedArrays4 find = new FindMedianSortedArrays4();

    public void test1() {
        double result = find.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.print(result);
    }

    public void test2() {
        double result = find.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.print(result);
    }

    public void test3() {
        double result = find.findMedianSortedArrays(new int[]{1, 2}, new int[]{});
        System.out.print(result);
    }

    public void test4() {
        double result = find.findMedianSortedArrays(new int[]{1}, new int[]{});
        System.out.println(result);
    }

    public void test5() {
        double result = find.findMedianSortedArrays(new int[]{3}, new int[]{-1, -2});
        System.out.println(result);
    }
}

