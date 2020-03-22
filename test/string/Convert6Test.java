package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/22
 */
public class Convert6Test {

    private Convert6 convert6 = new Convert6();

    @Test
    public void test1() {
        String str = convert6.convert("LEETCODEISHIRING", 3);
        Assert.assertEquals(str, "LCIRETOESIIGEDHN");
    }

    @Test
    public void test2() {
        String str = convert6.convert("LEETCODEISHIRING", 4);
        Assert.assertEquals(str, "LDREOEIIECIHNTSG");
    }

    @Test
    public void test3() {
        String str = convert6.convert("LEETCODEISHIRING", 5);
        Assert.assertEquals(str, "LIEESGEDHNTOIICR");
    }

    @Test
    public void test6() {
        String str = convert6.convert("LEETCODEISHIRING", 6);
        Assert.assertEquals(str, "LHESIEIRTEICDNOG");
    }

    @Test
    public void test7() {
        String str = convert6.convert("LEETCODEISHIRING", 7);
        Assert.assertEquals(str, "LREIIEHNTSGCIOED");
    }

    @Test
    public void test8() {
        String str = convert6.convert("LEETCODEISHIRING", 2);
        Assert.assertEquals(str, "LECDIHRNETOESIIG");
    }

    @Test
    public void test9() {
        String str = convert6.convert("LEETCODEISHIRING", 16);
        Assert.assertEquals(str, "LEETCODEISHIRING");
    }

    @Test
    public void test10() {
        String str = convert6.convert("LEETCODEISHIRING", 15);
        Assert.assertEquals(str, "LEETCODEISHIRIGN");
    }
}
