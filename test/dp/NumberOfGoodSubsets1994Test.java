package dp;

import junit.framework.TestCase;
import org.junit.Assert;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

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
        int[] nums = new int[]{1, 26, 1, 1, 21, 1, 3, 13, 1, 1, 1, 26, 29, 29, 6, 10, 29, 1, 1, 11, 15, 6, 14, 1, 17, 1, 1, 30, 21, 1, 17, 1, 1, 1, 23, 1, 7, 17, 15, 1, 1, 1, 14, 22, 11, 22, 17, 1, 19, 1, 2, 21, 29, 1, 22, 1, 1, 14, 22,
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
                6, 14, 1, 1, 1, 1, 1, 1, 1, 1, 1, 21, 1, 1, 1, 1, 1, 1, 1, 13, 1};
        int result = goodSubsets.numberOfGoodSubsets(nums);

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

    public void test13() {
        int[] nums = new int[]{1, 26, 1, 1, 21, 1, 3, 13, 1, 1, 1, 26, 29, 29, 6, 10, 29, 1, 1, 11, 15, 6, 14, 1, 17, 1, 1, 30, 21, 1, 17, 1, 1, 1, 23, 1, 7, 17, 15, 1, 1, 1, 14, 22, 11, 22, 17, 1, 19, 1, 2, 21, 29, 1, 22, 1, 1, 14, 22,
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
                6, 14, 1, 1, 1, 1, 1, 1, 1, 1, 1, 21, 1, 1, 1, 1, 1, 1, 1, 13, 1};
        Set<Integer> set = Arrays.stream(new int[]{2, 3, 5, 7, 10, 11, 13, 30}).boxed().collect(Collectors.toSet());
        nums = Arrays.stream(nums).filter(set::contains).toArray();
        int result = goodSubsets.numberOfGoodSubsets(nums);
        Assert.assertEquals(result, 897768681);
    }

    public void test14() {
        int[] nums = new int[]{7, 22, 7, 8, 27, 7, 19, 18, 4, 21, 22, 30, 27, 7, 26, 20, 16, 10, 13, 10, 10, 27, 7, 24, 10, 13, 30, 18, 17, 13, 8, 4, 24, 11, 15, 13, 23, 22, 18, 21, 9, 27, 25, 6, 18, 19, 28, 29, 1, 23, 25, 30, 24, 28, 5, 3, 24, 7, 9, 27, 17, 29, 7, 28, 22, 5, 10, 5, 25, 8, 5, 30, 12, 6, 30, 30, 23, 14, 18, 10, 23, 20, 28, 25, 8, 30, 9, 20, 4, 2, 15, 27, 15, 17, 23, 1, 6, 11, 21, 7, 29, 28, 2, 30, 1, 16, 29, 17, 18, 2, 26, 11, 13, 24, 7, 2, 3, 4, 16, 26, 24, 21, 8, 29, 10, 15, 14, 1, 13, 21, 20, 20, 20, 4, 2, 7, 8, 26, 6, 21, 14, 13, 1, 7, 23, 28, 8, 17, 26, 4, 26, 22, 10, 6, 30, 2, 14, 8, 10, 15, 8, 10, 10, 2, 13, 5, 7, 10, 19, 30, 17, 4, 2, 9, 15, 1, 29, 11, 29, 2, 21, 18, 26, 30, 12, 6, 14, 4, 28, 8, 14, 16, 21, 16, 6, 21, 30, 29, 7, 13, 4, 28, 7, 10, 8, 19, 3, 1, 21, 13, 17, 1, 20, 2, 25, 26, 30, 22, 29, 6, 16, 26, 6, 1, 17, 8, 4, 4, 16, 13, 22, 23, 19, 22, 4, 1, 5, 23, 3, 6, 11, 4, 25, 22, 11, 23, 19, 20, 7, 21, 19, 3, 15, 9, 2, 30, 1, 16, 24, 12, 1, 30, 30, 8, 11, 22, 18, 3, 26, 25, 13, 6, 6, 26, 27, 2, 3, 25, 15, 9, 22, 9, 1, 6, 27, 3, 24, 11, 29, 29, 12, 5, 13, 17, 27, 11, 14, 14, 23, 3, 17, 1, 9, 1, 2, 9, 14, 21, 5, 2, 9, 13, 28, 2, 24, 9, 25, 7, 23, 9, 30, 17, 23, 6, 22, 24, 12, 6, 30, 22, 4, 12, 7, 5, 16, 30, 22, 18, 18, 19, 15, 9, 9, 7, 9, 15, 21, 11, 8, 13, 22, 4, 21, 17, 21, 8, 2, 27, 23, 10, 21, 13, 4, 29, 8, 4, 23, 26, 1, 13, 29, 30, 3, 2, 11, 18, 22, 28, 19, 13, 13, 15, 20, 20, 19, 29, 29, 29, 10, 22, 15, 28, 7, 17, 2, 20, 15, 10, 13, 25, 7, 18, 4, 21, 4, 29, 12, 13, 29, 19, 18, 30, 26, 20, 23, 25, 14, 4, 20, 30, 22, 18, 24, 16, 5, 17, 28, 11, 9, 7, 13, 29, 10, 10, 13, 16, 9, 29, 13, 4, 8, 25, 4, 24, 28, 29, 24, 26, 24, 10, 14, 12, 3, 29, 24, 13, 21, 27, 26, 6, 6, 17, 11, 28, 12, 26, 5, 15, 11, 21, 3, 21, 27, 10, 28, 24, 18, 28, 30, 21, 14, 9, 30, 11, 5, 1, 13, 29, 27, 23, 29, 3, 15, 14, 7, 29, 13, 29, 26, 29, 18, 22, 25, 5, 28, 20, 5, 20, 1, 9, 1, 29, 26, 12, 24, 25, 1, 8, 1, 22, 12, 5, 23, 25, 21, 22, 28, 4, 2, 10, 11, 28, 9, 27, 11, 1, 19, 7, 12, 10, 16, 3, 14, 12, 3, 12, 11, 4, 4, 18, 7, 8, 13, 28, 24, 25, 26, 18, 25, 3, 5, 9, 2, 14, 24, 23, 29, 22, 15, 7, 20, 23, 1, 13, 23, 8, 21, 18, 7, 5, 18, 30, 16, 18, 7, 18, 16, 11, 13, 16, 9, 29, 6, 10, 21, 4, 3, 9, 27, 8, 30, 6, 10, 20, 11, 15, 24, 6, 21, 22, 17, 5, 23, 25, 22, 18, 1, 13, 22, 7, 15, 11, 6, 24, 5, 7, 18, 9, 27, 20, 5, 12, 17, 23, 6, 29, 23, 3, 16, 12, 6, 24, 4, 2, 30, 8, 28, 10, 18, 6, 7, 30, 22, 13, 21, 26, 7, 14, 23, 12, 10, 26, 20, 3, 11, 17, 28, 6, 2, 8, 26, 1, 21, 22, 24, 19, 25, 7, 26, 28, 6, 24, 16, 20, 9, 27, 11, 30, 8, 15, 2, 26, 24, 21, 4, 22, 4, 3, 25, 9, 26, 9, 5, 7, 12, 10, 11, 22, 16, 6, 3, 14, 10, 17, 14, 14, 21, 25, 27, 11, 29, 20, 11, 29, 8, 19, 9, 16, 11, 21, 18, 24, 28, 11, 26, 3, 4, 17, 20, 13, 19, 25, 15, 26, 1, 6, 22, 26, 21, 3, 18, 17, 21, 12, 16, 22, 12, 13, 5, 12, 30, 24, 8, 21, 15, 9, 2, 14, 16, 14, 12, 8, 30, 11, 9, 20, 21, 11, 17, 1, 6, 11, 16, 27, 2, 26, 17, 11, 26, 1, 9, 22, 26, 13, 11, 1, 9, 9, 7, 21, 30, 1, 22, 10, 28, 7, 7, 24, 5, 18, 15, 7, 15, 17, 26, 28, 1, 16, 5, 30, 27, 25, 24, 12, 16, 27, 9, 30, 15, 5, 14, 9, 23, 24, 27, 27, 20, 8, 30, 27, 23, 10, 28, 27, 18, 13, 15, 25, 22, 16, 2, 26, 24, 16, 15, 23, 10, 14, 2, 30, 12, 19, 25, 7, 5, 2, 18, 19, 23, 15, 17, 16, 15, 13, 23, 13, 21, 1, 11, 29, 3, 15, 8, 6, 15, 22, 20, 10, 11, 11, 22, 18, 2, 27, 28, 17, 22, 8, 10, 7, 2, 22, 5, 5, 30, 20, 11, 16, 13, 5, 18, 24, 26, 10, 28, 18, 15, 16, 2, 17, 27, 14, 8, 17, 6, 22, 30, 14, 19, 9, 3, 2, 5, 6, 25, 27, 20, 12, 21, 28, 2, 23, 1, 4, 3, 24, 6, 18, 10, 25, 19, 14, 12, 12, 22, 6, 13, 11, 19, 16, 30, 14, 1, 5, 27, 24, 29, 23, 2, 11, 21, 20, 29, 7, 6, 19, 24, 1, 28, 11, 17, 22, 12, 7, 5, 20, 18, 6, 10, 25, 4, 27, 2, 3, 22, 9, 27, 10, 4, 28, 30, 15, 13, 12, 11, 25, 2, 15, 5, 24, 6, 11, 16, 4, 30, 14, 27, 28, 28, 6, 16, 13, 19, 16, 2, 4, 13, 29, 22, 28, 16, 1, 27, 6, 8, 23, 17, 16, 9, 27, 26, 20, 23, 16, 8, 13, 4, 10, 1, 10, 23, 25, 20, 2, 14, 21, 14, 17, 30, 20, 21, 25, 28, 1, 14, 27, 25, 28, 30, 25, 6, 23, 1, 21, 6, 3, 25, 26, 7, 7, 2, 3, 28, 7, 11, 16, 16, 27, 14, 30, 21, 25, 21, 27, 10, 13, 14, 12, 25, 5, 1, 22, 21, 23, 30, 7, 19, 20, 23, 28, 8, 29, 26, 8, 11, 21, 25, 2, 29, 12, 10, 15, 27, 18, 12, 23, 26, 17, 22, 19, 8, 6, 12, 26, 2, 16, 24, 16, 1, 27, 17, 19, 22, 13, 1, 16, 25, 20, 23, 17, 3, 15, 27, 15, 5, 15, 8, 21, 12, 1, 11, 12, 18, 20, 26, 15, 5, 21, 11, 28, 4, 15, 16, 29, 21, 7, 3, 22, 11, 15, 10, 13, 25, 3, 2, 29, 16, 12, 13, 12, 1, 26, 8, 21, 15, 2, 12, 24, 18, 8, 13, 4, 24, 30, 23, 12, 29, 30, 26, 2, 5, 29, 21, 6, 22, 6, 10, 17, 1, 28, 8, 19, 7, 8, 23, 7, 17, 21, 15, 15, 26, 20, 9, 21, 28, 8, 13, 25, 27, 28, 14, 6, 18, 22, 26, 3, 9, 16, 10, 27, 21, 10, 26, 28, 11, 13, 8, 10, 13, 11, 10, 22, 20, 24, 26, 11, 30, 16, 21, 21, 13, 27, 22, 20, 23, 13, 20, 21, 9, 6, 1, 13, 4, 9, 27, 2, 9, 26, 19, 30, 20, 17, 25, 13, 16, 6, 13, 22, 11, 25, 4, 9, 23, 1, 19, 21, 6, 9, 29, 26, 27, 27, 1, 9, 1, 2, 19, 20, 6, 7, 2, 13, 3, 10, 20, 20, 14, 1, 10, 11, 6, 26, 24, 2, 9, 28, 25, 11, 18, 15, 23, 6, 6, 5, 30, 23, 19, 30, 21, 11, 14, 13, 1, 19, 17, 12, 27, 29, 30, 2, 12, 17, 2, 29, 11, 26, 5, 8, 2, 15, 28, 4, 18, 25, 12, 23, 14, 30, 14, 17, 15, 1, 9, 26, 30, 25, 17, 5, 28, 18, 26, 3, 19, 1, 11, 1, 11, 18, 9, 8, 13, 21, 28, 18, 18, 3, 2, 15, 28, 26, 2, 21, 18, 25, 6, 27, 10, 4, 1, 18, 25, 10, 9, 12, 25, 18, 12, 22, 20, 3, 30, 2, 22, 5, 5, 28, 27, 25, 15, 25, 29, 24, 13, 2, 16, 5, 5, 4, 9, 16, 8, 2, 27, 9, 14, 4, 11, 21, 19, 19, 8, 2, 6, 25, 24, 6, 12, 18, 8, 9, 2, 1, 4, 12, 18, 15, 10, 3, 15, 2, 14, 21, 24, 18, 26, 18, 7, 17, 15, 17, 20, 30, 5, 16, 25, 21, 11, 12, 4, 21, 1, 9, 23, 14, 14, 21, 15, 30, 14, 3, 14, 28, 5, 11, 12, 7, 19, 28, 28, 13, 18, 21, 13, 29, 18, 2, 28, 6, 5, 2, 18, 19, 28, 9, 9, 1, 15, 4, 16, 10, 22, 9, 26, 24, 18, 29, 10, 11, 28, 4, 17, 18, 23, 18, 12, 6, 20, 15, 27, 16, 15, 10, 19, 23, 21, 10, 2, 20, 29, 2, 21, 19, 23, 30, 29, 1, 18, 21, 30, 11, 4, 28, 2, 17, 5, 26, 23, 14, 18, 25, 17, 1, 12, 19, 14, 22, 6, 25, 3, 19, 5, 22, 30, 4, 1, 8, 13, 11, 16, 8, 23, 17, 4, 5, 7, 21, 12, 20, 30, 5, 1, 19, 27, 23, 23, 5, 4, 16, 3, 5, 3, 20, 7, 14, 9, 3, 5, 15, 21, 6, 19, 8, 17, 16, 3, 26, 19, 15, 22, 2, 4, 18, 20, 28, 22, 22, 24, 16, 8, 14, 9, 15, 29, 3, 13, 30, 20, 23, 18, 4, 10, 26, 21, 7, 9, 20, 14, 28, 1, 6, 29, 15, 28, 6, 18, 15, 25, 28, 24, 21, 14, 20, 1, 4, 8, 18, 25, 17, 5, 11, 27, 3, 12, 20, 20, 20, 30, 27, 16, 18, 3, 22, 10, 8, 22, 11, 9, 7, 26, 22, 2, 30, 21, 22, 8, 10, 27, 15, 8, 18, 22, 13, 16, 18, 1, 14, 30, 24, 24, 27, 24, 20, 15, 25, 15, 10, 30, 3, 19, 25, 26, 7, 9, 12, 1, 24, 5, 25, 15, 7, 29, 14, 18, 5, 13, 12, 2, 15, 26, 5, 23, 23, 11, 25, 25, 21, 5, 30, 1, 16, 8, 7, 17, 22, 1, 15, 13, 4, 25, 3, 25, 22, 10, 29, 12, 21, 15, 7, 6, 1, 21, 4, 27, 25, 5, 15, 4, 6, 23, 24, 23, 1, 5, 24, 13, 29, 19, 30, 20, 3, 29, 29, 24, 24, 28, 18, 4, 30, 21, 13, 10, 1, 10, 18, 17, 8, 13, 25, 29, 15, 12, 30, 19, 20, 6, 20, 28, 9, 6, 16, 19, 5, 6, 15, 25, 2, 1, 4, 14, 25, 12, 13, 2, 30, 1, 30, 19, 17, 25, 28, 27, 6, 24, 7, 3, 26, 5, 24, 15, 3, 23, 26, 2, 22, 26, 23, 4, 14, 17, 12, 14, 12, 19, 23, 2, 27, 20, 14, 9, 16, 25, 10, 19, 28, 15, 12, 20, 20, 9, 18, 1, 7, 1, 7, 21, 30, 27, 15, 13, 7, 1, 10, 8, 5, 18, 15, 24, 18, 17, 22, 28, 28, 11, 9, 22, 9, 1, 3, 11, 24, 28, 10, 28, 21, 27, 9, 22, 14, 5, 4, 14, 14, 6, 30, 2, 19, 18, 26, 5, 4, 25, 15, 13, 12, 26, 30, 6, 17, 27, 1, 23, 2, 12, 3, 30, 6, 29, 2, 18, 6, 22, 16, 2, 19, 20, 1, 6, 24, 14, 2, 28, 22, 21, 24, 2, 12, 20, 7, 15, 17, 11, 21, 21, 13, 22, 29, 17, 29, 21, 6, 26, 26, 25, 18, 15, 20, 2, 3, 3, 19, 24, 7, 2, 3, 19, 2, 25, 12, 21, 21, 19, 7, 9, 24, 26, 15, 22, 14, 4, 25};
        int result = goodSubsets.numberOfGoodSubsets(nums);
        Assert.assertEquals(result, 557686989);
    }
}
