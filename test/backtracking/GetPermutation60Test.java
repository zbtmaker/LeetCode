package backtracking;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/09/05
 */
public class GetPermutation60Test extends TestCase {
    private GetPermutation60 permutation = new GetPermutation60();

    public void test1() {
        String str = permutation.getPermutationII(3, 3);
        Assert.assertEquals(str, "213");
    }

    public void test2() {
        String str = permutation.getPermutationII(3, 4);
        Assert.assertEquals(str, "231");
    }

    public void test3() {
        String str = permutation.getPermutationII(3, 1);
        Assert.assertEquals(str, "123");
    }

    public void test4() {
        String str = permutation.getPermutationII(3, 2);
        Assert.assertEquals(str, "132");
    }

    public void test5() {
        String str = permutation.getPermutationII(3, 5);
        Assert.assertEquals(str, "312");
    }

    public void test6() {
        String str = permutation.getPermutationII(3, 6);
        Assert.assertEquals(str, "321");
    }

    public void test7() {
        String str = permutation.getPermutationII(2, 1);
        Assert.assertEquals(str, "12");
    }


    public void test8() {
        String str = permutation.getPermutationII(2, 2);
        Assert.assertEquals(str, "21");
    }

    public void test9() {
        String str = permutation.getPermutationII(1, 1);
        Assert.assertEquals(str, "1");
    }

    public void test10() {
        String str = permutation.getPermutationII(4, 1);
        Assert.assertEquals(str, "1234");
    }


    public void test11() {
        String str = permutation.getPermutationII(4, 1);
        Assert.assertEquals(str, "1234");
    }
}
