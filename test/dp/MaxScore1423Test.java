package dp;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/05/26
 */
public class MaxScore1423Test extends TestCase {

    private MaxScore1423 maxScore = new MaxScore1423();

    public void test1() {
        int score = maxScore.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3);
        Assert.assertEquals(score, 12);
    }

    public void test2() {
        int score = maxScore.maxScore(new int[]{2, 2, 2}, 2);
        Assert.assertEquals(score, 4);
    }

    public void test3() {
        int score = maxScore.maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7);
        Assert.assertEquals(score, 55);
    }

    public void test4() {
        int score = maxScore.maxScore(new int[]{1, 1000, 1}, 1);
        Assert.assertEquals(score, 1);
    }

    public void test5() {
        int score = maxScore.maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3);
        Assert.assertEquals(score, 202);
    }

    public void test6() {
        int score = maxScore.maxScore(new int[]{53, 14, 91, 35, 51, 9, 80, 27, 6, 15, 77, 86, 34, 62, 55, 45, 91, 45, 23, 75, 66, 42, 62, 13, 34, 18, 89, 67, 93, 83, 100, 14, 92, 73, 48, 2, 47, 93, 99, 100, 88, 84, 48}, 43);
        Assert.assertEquals(score, 2429);
    }
}
