package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/01/27
 */
public class ReverseWords151Test {
    private ReverseWords151 reverse = new ReverseWords151();

    @Test
    public void test1(){
        String str = "a good   example";
        str = reverse.reverseWords(str);
        Assert.assertEquals(str,"example good a");
    }

    @Test
    public void test2(){
        String str = "  hello world!  ";
        str = reverse.reverseWords(str);
        Assert.assertEquals(str,"world! hello");
    }

    @Test
    public void test3(){
        String str = "hello ";
        str = reverse.reverseWords(str);
        Assert.assertEquals(str,"hello");
    }

    @Test
    public void test4(){
        String str = "   a   ";
        str = reverse.reverseWords(str);
        Assert.assertEquals(str,"a");
    }

    @Test
    public void test5(){
        String str = " ";
        str = reverse.reverseWords(str);
        Assert.assertEquals(str,"");
    }
}
