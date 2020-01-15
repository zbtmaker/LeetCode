package string;

import org.junit.Assert;
import org.junit.Test;

public class LengthOfLastWord58Test {
    private LengthOfLastWord58 lengthOfLastWord = new LengthOfLastWord58();

    @Test
    public void test1() {
        int len = lengthOfLastWord.lengthOfLastWord("Hello World");
        Assert.assertEquals(len, 5);
    }

    @Test
    public void test2() {
        int len = lengthOfLastWord.lengthOfLastWord("hello");
        Assert.assertEquals(len, 5);
    }

    @Test
    public void test3() {
        int len = lengthOfLastWord.lengthOfLastWord("hello ");
        Assert.assertEquals(len, 5);
    }

    @Test
    public void test4() {
        int len = lengthOfLastWord.lengthOfLastWord(" hello");
        Assert.assertEquals(len, 5);
    }

    @Test
    public void test5() {
        int len = lengthOfLastWord.lengthOfLastWord(" hello ");
        Assert.assertEquals(len, 5);
    }
    @Test
    public void test6() {
        int len = lengthOfLastWord.lengthOfLastWord("a ");
        Assert.assertEquals(len, 1);
    }

    @Test
    public void test7() {
        int len = lengthOfLastWord.lengthOfLastWord(" a");
        Assert.assertEquals(len, 1);
    }

    @Test
    public void test8() {
        int len = lengthOfLastWord.lengthOfLastWord(" ");
        Assert.assertEquals(len, 0);
    }

    @Test
    public void test9(){
        int len = lengthOfLastWord.lengthOfLastWord(" hello world a ");
        Assert.assertEquals(len, 1);
    }
}
