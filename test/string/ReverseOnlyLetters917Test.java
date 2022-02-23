package string;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author zoubaitao
 * date 2022/02/23
 */
public class ReverseOnlyLetters917Test extends TestCase {

    private final ReverseOnlyLetters917 reverse = new ReverseOnlyLetters917();

    public void test1() {
        String result = reverse.reverseOnlyLetters("ab-cd");
        Assert.assertEquals(result, "dc-ba");
    }

    public void test2() {
        String result = reverse.reverseOnlyLetters("a-bC-dEf-ghIj");
        Assert.assertEquals(result, "j-Ih-gfE-dCba");
    }

    public void test3() {
        String result = reverse.reverseOnlyLetters("Test1ng-Leet=code-Q!");
        Assert.assertEquals(result, "Qedo1ct-eeLg=ntse-T!");
    }
}
