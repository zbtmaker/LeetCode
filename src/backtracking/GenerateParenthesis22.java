package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\11 0011.
 */
public class GenerateParenthesis22 {


    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (open == max && close == max) {
            ans.add(cur);
            return;
        }

        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }

}
