package backtracking;

import junit.framework.TestCase;

import java.util.List;

/**
 * @author baitao zou
 * date 2020/11/28
 */
public class GenerateParenthesis22Test extends TestCase {

    private GenerateParenthesis22 generateParenthesis = new GenerateParenthesis22();

    public void test1() {
        List<String> result = generateParenthesis.generateParenthesis(2);
        System.out.println(result.toString());
    }


    public void test2() {
        List<String> result = generateParenthesis.generateParenthesis(1);
        System.out.println(result.toString());
    }

    public void test3() {
        List<String> result = generateParenthesis.generateParenthesis(3);
        System.out.println(result.toString());
    }

    public void test4() {
        List<String> result = generateParenthesis.generateParenthesis(4);
        System.out.println(result.toString());
    }
}
