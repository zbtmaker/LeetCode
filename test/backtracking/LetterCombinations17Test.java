package backtracking;

import array.CommonUtil;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

/**
 * @author zoubaitao
 * date 2022/02/26
 */
public class LetterCombinations17Test extends TestCase {

    private final LetterCombinations17 combinations = new LetterCombinations17();

    public void test1() {
        List<String> result = combinations.letterCombinations("23");
        Assert.assertArrayEquals(CommonUtil.listToStringArr(result), new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"});
    }
}
