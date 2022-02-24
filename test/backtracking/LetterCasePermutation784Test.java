package backtracking;

import array.CommonUtil;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author zoubaitao
 * date 2022/02/24
 */
public class LetterCasePermutation784Test extends TestCase {

    private final LetterCasePermutation784 letter = new LetterCasePermutation784();

    public void test1() {
        List<String> list = letter.letterCasePermutation("a1b2");
        Assert.assertArrayEquals(CommonUtil.listToStringArr(list),
                new String[]{"a1b2", "a1B2", "A1b2", "A1B2"});
    }

    public void test2() {
        List<String> list = letter.letterCasePermutation("3z4");
        Assert.assertArrayEquals(CommonUtil.listToStringArr(list),
                new String[]{"3z4", "3Z4"});
    }
}
