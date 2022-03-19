package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/22
 */
public class NumberOfGoodSubsets1994Test extends TestCase {
    private final NumberOfGoodSubsets1994 goodSubsets = new NumberOfGoodSubsets1994();

    public void test1() {
        int result = goodSubsets.numberOfGoodSubsets(new int[]{1, 2, 3, 4});
        Assert.assertEquals(result, 6);
    }

    public void test2() {
        int result = goodSubsets.numberOfGoodSubsets(new int[]{4, 2, 3, 15});
        Assert.assertEquals(result, 5);
    }

    public void test3() {
        int result = goodSubsets.numberOfGoodSubsets(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        Assert.assertEquals(result, 0);
    }

    public void test4() {
        int result = goodSubsets.numberOfGoodSubsets(new int[]{16, 23, 16, 24, 13, 7, 13, 9, 9, 20, 19, 15,
                19, 26, 11, 27, 6, 4, 1, 7, 3, 29, 29, 5, 7, 20, 21, 22, 17, 27, 15, 1, 1, 13, 17, 23, 29, 15, 27, 29, 30, 19,
                19, 30, 22, 1, 25, 4, 13, 24, 20, 12, 30, 14, 21, 7, 26, 6, 7, 18, 25});
        Assert.assertEquals(result, 5738384);
    }

    public void test5() {
        double a = Math.pow(2, 100);
        System.out.println(a);
        int result = goodSubsets.numberOfGoodSubsets(new int[]{10, 11, 5, 1, 10, 1, 3, 1, 26, 11, 6, 1, 1, 15, 1, 7, 22, 1, 1, 1, 1, 1, 23, 1, 29, 5, 6, 1, 1, 29, 1, 1, 21, 19, 1, 1, 1, 2, 1, 11, 1, 15,
                1, 22, 14, 1, 1, 1, 1, 6, 7, 1, 14, 3, 5, 1, 22, 1, 1, 1, 17, 1, 29, 2, 1, 15, 10, 1, 5, 7, 1, 1, 1, 30, 1, 30, 1, 21, 10, 1, 1, 1, 1, 1, 2, 6, 5, 7, 3, 1, 1, 19, 29, 1, 7, 13, 14, 1, 5,
                26, 19, 11, 1, 1, 1, 1, 1, 1, 1, 1, 22, 15, 1, 1, 13, 1, 17, 1, 1, 1, 13, 6, 1, 10, 1, 1, 17, 1, 1, 3, 14, 7, 17, 1, 13, 1, 1, 1, 1, 1, 11, 1, 1, 6, 1, 1, 1, 1, 1, 2, 1, 30, 2, 26, 1, 1,
                14, 1, 26, 29, 30, 1, 13, 21, 1, 1, 14, 21, 1, 23, 1, 15, 23, 21, 1, 30, 19, 19, 1, 10, 23, 3, 3, 17, 22, 2, 26, 1, 11, 1, 23, 1, 1, 1, 15, 1, 1, 13, 1, 1});
        Assert.assertEquals(result, 520317213);
    }


    public void test6() {
        int result = goodSubsets.numberOfGoodSubsets(new int[]{28, 21, 9, 24, 16, 5, 7, 15, 17, 30, 5, 30, 15, 2, 30, 27, 5, 1, 27, 29, 25, 27, 26, 20, 13, 7, 2, 12, 14, 15, 3, 15, 25, 28, 10, 15, 3, 6,
                1, 26, 20, 16, 10, 22, 21, 25, 26, 11, 6, 10, 27, 15, 17, 1, 7, 1, 14, 22, 15, 9, 14, 4, 20, 5, 3, 15, 4, 9, 24, 30, 28, 13, 29, 28, 12, 6, 12, 11, 8, 3, 18, 25, 28, 10, 15, 28, 27, 22,
                10, 26, 28, 27, 24, 24, 8, 12, 8, 29, 2, 23, 18, 6, 19, 19, 18, 26, 20, 30, 30, 30, 27, 8, 24, 25, 5, 30, 25, 1, 6, 12, 12, 7, 17, 26, 19, 21, 22, 2, 6, 20, 7, 10, 14, 25, 10, 27, 24, 9,
                7, 6, 25, 18, 30, 25, 13, 7, 28, 9, 4, 26, 15, 12, 14, 30, 8, 23, 25, 23, 7, 3, 6, 1, 30, 4, 30, 22, 1, 11, 21, 13, 25, 24, 20, 7, 23, 28, 28, 16, 6, 14, 12, 26, 9, 9, 21, 14, 7, 7, 13,
                6, 4, 15, 30, 24, 4, 28, 24, 16, 9, 26, 26, 21, 26, 9, 17, 29, 23, 9, 16, 27, 1, 13, 14, 11, 16, 23, 30, 26, 28, 4, 30, 9, 27, 7, 14, 23, 4, 30, 2, 8, 10, 3, 29, 26, 29, 18, 13, 16, 3, 5,
                1, 23, 8, 19, 27, 21, 22, 2, 17, 28, 18, 29, 12, 14, 25, 8, 29, 19, 30, 13, 16, 10, 15, 23, 14, 19, 19, 5, 6, 19, 28, 10, 27, 11, 7, 25, 18, 14, 20, 2, 23, 6, 9, 20, 16, 24, 29, 9, 14, 7,
                28, 22, 5, 16, 26, 20, 30, 27, 21, 1, 7, 10, 19, 9, 25, 22, 12, 29, 7, 19, 5, 27, 8, 4, 26, 3, 20, 29, 25, 30, 24, 20, 3, 3, 2, 18, 14, 30, 10, 8, 22, 17, 21, 12, 28, 26, 7, 29, 1, 27, 28,
                4, 16, 19, 17, 16, 15, 4, 3, 6, 7, 24, 2, 1, 22, 13, 27, 18, 16, 16, 9, 11, 28, 1, 29, 14, 3, 12, 16, 13, 27, 19, 28, 23, 1, 11, 17, 13, 3, 13, 8, 14, 15, 14, 19, 21, 19, 21, 8, 28, 28, 12,
                12, 25, 10, 28, 12, 17, 6, 7, 21, 26, 15, 28, 26, 13, 18, 2, 22, 14, 10, 18, 25, 1, 21, 14, 30, 20, 17, 4, 9, 18, 13, 20, 8, 6, 6, 16, 20, 13, 22, 9, 14, 14, 18, 10, 25, 14, 14, 3, 29, 19,
                14, 21, 16, 30, 2, 8, 16, 25, 24, 12, 29, 4, 30, 7, 25, 7, 18, 20, 11, 29, 29, 19, 27, 29, 27, 21, 24, 23, 16, 11, 11, 26, 30, 1, 19, 13, 19, 10, 22, 18, 10, 27, 12, 9, 22, 18, 14, 8, 19, 16,
                6, 23, 13, 15, 18, 5, 22, 29, 23, 23, 12, 24, 1, 14, 22, 4, 30, 16, 29, 30, 14, 21, 25, 6, 20, 11, 18, 19, 12, 20, 3, 28, 29, 10, 11, 21, 17, 20, 30, 3, 17, 19, 26, 2, 15, 5, 24, 18, 13, 25,
                27, 29, 1, 7, 11, 19, 8, 20, 8, 22, 6, 25, 3, 15, 20, 21, 23, 5, 24, 2, 27, 11, 5, 23, 8, 27, 27, 24, 23, 16, 10, 14, 9, 6, 2, 11, 12, 8, 21, 18, 26, 25, 6, 20, 25, 30, 3, 14, 14, 26, 30, 7,
                17, 24, 1, 3, 10, 26, 29, 22, 10, 18, 26, 19, 10, 8, 22, 24, 8, 9, 7, 12, 12, 12, 11, 27, 23, 2, 11, 4, 15, 11, 4, 13, 27, 7, 5, 22, 6, 5, 6, 1, 7, 10, 5, 12, 12, 3, 24, 13, 4, 3, 13, 18, 2,
                19, 6, 14, 17, 25, 22, 7, 23, 6, 25, 12, 15, 9, 19, 26, 12, 8, 1, 12, 17, 21, 15, 17, 8, 28, 30, 5, 4, 28, 27, 2, 21, 26, 8, 13, 26, 26, 27, 9, 19, 30, 17, 9, 18, 19, 6, 7, 25, 15, 23, 21, 23,
                3, 20, 25, 1, 16, 15, 12, 21, 24, 19, 16, 17, 8, 7, 18, 27, 27, 6, 14, 11, 13, 29, 18, 6, 19, 26, 11, 8, 16, 18, 28, 12, 3, 8, 3, 30, 7, 3, 6, 10, 30});
        Assert.assertEquals(result, 535252249);
    }

    public void test7() {
        int result = goodSubsets.numberOfGoodSubsets(new int[]{1, 26, 1, 1, 21, 1, 3, 13, 1, 1, 1, 26, 29, 29, 6, 10, 29, 1, 1, 11, 15, 6, 14, 1, 17, 1, 1, 30, 21, 1, 17, 1, 1, 1, 23, 1, 7, 17, 15, 1, 1, 1, 14, 22, 11, 22, 17, 1, 19, 1, 2, 21, 29, 1, 22, 1, 1, 14, 22,
                1, 14, 1, 1, 1, 1, 17, 1, 1, 1, 3, 1, 14, 19, 1, 1, 1, 1, 21, 26, 1, 1, 1, 13, 1, 1, 30, 21, 1, 1, 1, 1, 7, 1, 1, 7, 13, 6, 1, 29, 29, 1, 1, 23, 1, 19, 10, 10, 1, 1, 2, 1, 1, 23, 15, 5, 15, 1, 1, 19, 15, 1, 1, 14, 1, 7, 26, 1, 1, 2, 13, 19, 1, 3, 22, 1, 1, 29, 1, 7, 1, 1, 1, 1,
                3, 1, 1, 1, 3, 1, 1, 1, 2, 17, 1, 1, 1, 1, 1, 19, 5, 1, 1, 1, 19, 30, 23, 1, 1, 2, 1, 1, 7, 17, 1, 1, 1, 30, 21, 1, 3, 1, 5, 15, 1, 26, 1, 1, 21, 22, 19, 1, 13, 6, 15, 19, 2, 1, 1, 1, 1, 11, 17, 21, 29, 23, 26, 10, 1, 30, 1, 14, 1, 1, 21, 1, 30, 1, 1, 1, 11, 22, 19, 21, 30, 11,
                14, 1, 1, 3, 7, 17, 10, 10, 3, 1, 1, 1, 10, 1, 15, 1, 15, 15, 1, 1, 1, 1, 1, 21, 14, 6, 1, 17, 1, 1, 1, 17, 10, 3, 1, 22, 21, 1, 1, 23, 19, 1, 5, 5, 5, 10, 1, 29, 1, 1, 1, 1, 7, 1, 15, 1, 6, 6, 1, 1, 1, 13, 1, 1, 29, 17, 1, 1, 1, 6, 1, 1, 2, 13, 10, 29, 1, 13, 21, 7, 10, 1, 1,
                1, 7, 29, 15, 29, 17, 5, 30, 1, 11, 1, 23, 1, 1, 1, 5, 1, 30, 6, 1, 5, 6, 1, 11, 17, 26, 1, 1, 13, 1, 26, 1, 11, 13, 1, 11, 1, 1, 1, 30, 1, 1, 1, 14, 19, 1, 1, 15, 21, 1, 1, 2, 1, 1, 19, 1, 26, 1, 5, 22, 13, 1, 1, 11, 7, 29, 3, 26, 30, 19, 10, 1, 7, 1, 22, 1, 6, 2, 1, 23, 26, 1,
                11, 11, 5, 1, 1, 1, 5, 6, 7, 21, 1, 1, 10, 1, 1, 29, 1, 1, 6, 19, 1, 1, 5, 1, 30, 1, 15, 1, 3, 15, 15, 23, 6, 1, 5, 1, 1, 1, 1, 3, 1, 1, 17, 7, 1, 11, 6, 13, 2, 17, 1, 3, 1, 22, 1, 1, 23, 13, 1, 3, 1, 1, 1, 1, 13, 22, 1, 22, 1, 10, 1, 23, 15, 14, 1, 30, 1, 1, 29, 17, 3, 1, 19, 1,
                7, 14, 2, 1, 14, 23, 2, 30, 1, 19, 1, 1, 10, 19, 23, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 26, 30, 26, 1, 2, 2, 21, 1, 1, 1, 1, 1, 1, 1, 1, 1, 22, 15, 21, 15, 13, 26, 1, 1, 1, 1, 21, 1, 13, 30, 1, 22, 1, 14, 1, 21, 15, 14, 21, 1, 22, 1, 1, 1, 11, 1, 6, 6, 1, 1, 1, 13, 3, 10, 23, 15, 30,
                1, 1, 7, 19, 7, 1, 30, 15, 1, 7, 1, 11, 2, 17, 14, 17, 21, 1, 1, 17, 1, 3, 23, 1, 1, 11, 21, 1, 1, 1, 1, 10, 1, 11, 1, 1, 1, 1, 6, 22, 1, 1, 6, 26, 23, 1, 1, 11, 10, 1, 6, 6, 1, 26, 1, 1, 1, 1, 1, 1, 1, 1, 1, 22, 1, 19, 13, 1, 1, 2, 10, 1, 26, 1, 1, 5, 3, 10, 13, 11, 17, 1, 1, 23, 1,
                7, 5, 1, 1, 11, 22, 1, 23, 1, 1, 1, 29, 26, 2, 1, 19, 15, 13, 29, 1, 1, 19, 26, 1, 11, 26, 11, 1, 6, 1, 1, 26, 21, 3, 2, 1, 1, 10, 1, 1, 21, 15, 1, 1, 23, 1, 2, 5, 1, 3, 1, 1, 1, 14, 5, 1, 21, 1, 30, 11, 5, 21, 14, 14, 1, 1, 19, 10, 1, 1, 1, 1, 22, 14, 1, 7, 23, 1, 29, 23, 1, 1, 1, 17,
                1, 1, 1, 15, 17, 22, 26, 1, 1, 1, 1, 1, 13, 13, 11, 1, 1, 1, 1, 5, 10, 1, 1, 1, 15, 1, 5, 1, 1, 1, 22, 1, 15, 11, 1, 1, 1, 13, 1, 1, 13, 1, 23, 1, 1, 6, 1, 6, 1, 1, 19, 1, 17, 1, 13, 1, 22, 1, 1, 1, 1, 13, 6, 1, 1, 1, 19, 7, 1, 23, 1, 1, 21, 1, 1, 6, 1, 3, 29, 21, 15, 1, 1, 1, 1, 1, 1, 1,
                14, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 10, 21, 11, 17, 23, 30, 1, 30, 3, 11, 1, 1, 1, 1, 22, 2, 1, 1, 11, 6, 23, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 23, 1, 23, 21, 3, 19, 1, 1, 26, 30, 1, 1, 1, 30, 1, 1, 1, 5, 1, 1, 1, 1, 29, 1, 7, 1, 1, 2, 1, 30, 7, 17, 7, 13, 1, 1, 29, 1, 1, 1, 1, 26, 1, 1, 6, 13,
                1, 1, 1, 11, 1, 30, 1, 14, 11, 30, 1, 1, 1, 1, 1, 14, 1, 26, 6, 26, 1, 7, 23, 1, 11, 13, 2, 23, 1, 7, 22, 1, 1, 1, 5, 22, 15, 1, 11, 1, 21, 1, 1, 13, 26, 30, 1, 22, 1, 1, 14, 29, 1, 1, 1, 1, 1, 30, 2, 1, 1, 29, 1, 1, 3, 21, 11, 1, 3, 22, 5, 6, 10, 1, 1, 1, 1, 26, 11, 1, 22, 14, 1, 14, 1, 21, 1,
                10, 23, 1, 13, 1, 29, 19, 1, 14, 1, 22, 1, 1, 1, 1, 29, 29, 3, 1, 1, 19, 10, 5, 1, 1, 1, 22, 1, 1, 14, 2, 1, 1, 1, 1, 23, 1, 6, 1, 1, 2, 1, 15, 10, 3, 22, 1, 1, 1, 1, 1, 1, 11, 1, 1, 5, 1, 1, 6, 30, 1, 17, 1, 1, 2, 1, 1, 5, 1, 1, 19, 10, 29, 22, 1, 10, 3, 1, 6, 1, 7, 13, 1, 3, 29, 1, 1, 1, 1, 26,
                1, 1, 1, 21, 1, 29, 1, 1, 5, 1, 1, 5, 1, 1, 13, 1, 1, 1, 1, 1, 1, 22, 1, 1, 5, 1, 2, 30, 1, 14, 1, 1, 5, 1, 11, 1, 14, 11, 1, 13, 15, 11, 1, 1, 29, 5, 26, 26, 1, 1, 1, 14, 1, 1, 1, 10, 1, 1, 30, 30, 1, 6, 2, 1, 5, 1, 1, 1, 19, 13, 3, 10, 1, 1, 1, 3, 1, 1, 1, 1, 1, 15, 1, 13, 2, 1, 1, 1, 1, 6, 11,
                1, 1, 1, 1, 23, 17, 22, 15, 1, 1, 3, 19, 10, 1, 7, 1, 23, 1, 1, 1, 15, 23, 11, 1, 22, 1, 19, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1, 5, 19, 6, 30, 1, 6, 14, 1, 1, 1, 10, 1, 7, 1, 5, 1, 1, 1, 1, 1, 15, 1, 17, 7, 7, 29, 23, 26, 6, 3, 10, 3, 2, 10, 1, 5, 22, 1, 1, 1, 1, 1, 1, 2, 30, 26, 21, 1, 1, 1, 1, 1, 1, 29,
                1, 7, 1, 11, 17, 1, 6, 6, 7, 1, 17, 22, 1, 17, 1, 26, 1, 1, 23, 1, 1, 1, 1, 1, 1, 1, 19, 1, 7, 1, 2, 30, 1, 1, 30, 17, 1, 1, 21, 30, 29, 1, 1, 1, 7, 26, 1, 14, 1, 1, 5, 1, 3, 7, 1, 1, 1, 10, 1, 15, 1, 1, 1, 1, 15, 1, 11, 1, 1, 1, 1, 29, 13, 23, 10, 1, 1, 1, 1, 5, 13, 1, 1, 1, 1, 26, 1, 1, 17, 1, 1, 1,
                19, 26, 1, 1, 1, 22, 1, 23, 13, 19, 1, 29, 1, 1, 29, 30, 5, 1, 2, 1, 23, 5, 26, 1, 1, 1, 10, 1, 21, 22, 15, 1, 3, 1, 1, 1, 15, 1, 2, 1, 1, 22, 29, 1, 1, 1, 17, 19, 19, 1, 3, 1, 1, 1, 1, 22, 3, 1, 1, 6, 1, 3, 1, 1, 10, 21, 1, 1, 21, 6, 1, 1, 1, 13, 2, 5, 3, 1, 15, 15, 22, 1, 1, 1, 2, 1, 2, 3, 1, 14, 1,
                1, 10, 1, 26, 13, 6, 13, 23, 14, 1, 14, 1, 3, 17, 7, 1, 17, 1, 1, 17, 1, 26, 30, 30, 10, 22, 1, 1, 3, 5, 21, 1, 1, 14, 1, 1, 1, 1, 5, 26, 1, 29, 19, 17, 23, 23, 11, 1, 7, 2, 15, 14, 1, 19, 1, 13, 1, 15, 14, 1, 29, 2, 1, 2, 26, 5, 19, 1, 14, 21, 19, 1, 1, 1, 1, 21, 1, 1, 1, 1, 1, 29, 14, 1, 1, 1, 1, 7,
                1, 15, 1, 21, 13, 1, 1, 13, 1, 15, 1, 6, 1, 1, 1, 1, 1, 2, 7, 1, 1, 26, 14, 3, 1, 1, 1, 1, 1, 30, 10, 1, 21, 13, 1, 1, 1, 17, 1, 19, 11, 1, 1, 1, 29, 13, 1, 1, 30, 1, 30, 1, 19, 10, 22, 10, 6, 1, 21, 15, 1, 22, 1, 1, 29, 26, 1, 19, 1, 7, 1, 1, 17, 15, 1, 7, 1, 1, 10, 22, 13, 1, 22, 1, 1, 17, 1, 26, 1,
                1, 11, 1, 17, 1, 26, 1, 1, 11, 6, 1, 1, 3, 1, 3, 6, 2, 1, 1, 29, 1, 3, 13, 17, 30, 1, 1, 30, 1, 1, 1, 1, 2, 1, 1, 29, 1, 1, 14, 5, 1, 14, 5, 1, 1, 2, 2, 14, 23, 5, 10, 19, 10, 1, 1, 1, 1, 22, 1, 21, 3, 23, 1, 1, 1, 1, 15, 1, 26, 6, 1, 30, 10, 7, 15, 1, 1, 1, 1, 10, 19, 1, 2, 1, 1, 26, 1, 1, 2, 21, 1,
                22, 23, 5, 29, 1, 1, 1, 30, 14, 1, 1, 1, 5, 1, 1, 1, 1, 1, 6, 1, 1, 6, 2, 1, 1, 7, 1, 1, 21, 15, 11, 1, 30, 23, 1, 1, 1, 1, 1, 17, 1, 1, 15, 1, 1, 17, 15, 10, 3, 1, 17, 1, 1, 30, 30, 1, 11, 3, 1, 1, 22, 1, 11, 2, 29, 1, 22, 14, 1, 29, 17, 2, 19, 1, 1, 1, 1, 1, 23, 3, 23, 26, 1, 6, 1, 1, 2, 3, 26, 10,
                1, 7, 1, 7, 1, 5, 7, 15, 21, 1, 6, 5, 23, 7, 5, 19, 3, 11, 17, 1, 10, 1, 1, 1, 7, 1, 1, 1, 1, 29, 1, 14, 29, 1, 1, 5, 30, 1, 11, 29, 14, 19, 1, 1, 5, 1, 22, 1, 1, 7, 6, 26, 3, 21, 1, 30, 1, 13, 1, 1, 5, 1, 1, 29, 1, 1, 29, 1, 21, 1, 14, 14, 1, 29, 14, 1, 1, 14, 1, 1, 13, 26, 15, 1, 1, 23, 10, 30, 1,
                1, 17, 1, 1, 1, 1, 1, 17, 2, 1, 5, 13, 23, 1, 7, 14, 1, 3, 14, 1, 1, 7, 23, 1, 23, 6, 15, 17, 1, 19, 1, 1, 17, 1, 11, 1, 19, 10, 17, 21, 1, 1, 1, 7, 1, 11, 1, 13, 1, 1, 22, 22, 7, 26, 1, 2, 21, 19, 19, 1, 30, 11, 23, 17, 1, 19, 10, 1, 29, 1, 7, 15, 1, 1, 21, 23, 11, 6, 2, 11, 30, 1, 26, 1, 2, 13, 26,
                6, 14, 1, 1, 1, 1, 1, 1, 1, 1, 1, 21, 1, 1, 1, 1, 1, 1, 1, 13, 1});
        Assert.assertEquals(result, 870506303);
    }

    public void test8() {
        int result = goodSubsets.numberOfGoodSubsets(new int[]{1, 1, 2, 2, 3, 3});
        Assert.assertEquals(result, 32);
    }

    public void test9() {
        int result = goodSubsets.numberOfGoodSubsets(new int[]{1, 1, 2, 3, 3});
        Assert.assertEquals(result, 20);
    }

    public void test10() {
        int result = goodSubsets.numberOfGoodSubsets(new int[]{1, 2, 3, 30, 30, 30, 30});
        Assert.assertEquals(result, 14);
    }

    public void test11() {
        int result = goodSubsets.numberOfGoodSubsets(new int[]{2, 3, 5, 6, 7, 10, 11, 13, 14, 15, 17, 19, 21, 22, 23, 26, 29, 30});
        Assert.assertEquals(result, 3327);
    }

    public void test12() {
        int result = goodSubsets.numberOfGoodSubsets(new int[]{2, 2, 3, 3});
        Assert.assertEquals(result, 8);
    }
}
