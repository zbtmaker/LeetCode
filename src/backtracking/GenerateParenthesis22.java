package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\11 0011.
 */
public class GenerateParenthesis22 {

    /**
     * 这个题目之前没有写过题解，所以再一次做的时候还是一脸的懵逼，
     * 第一点，我们始终把括号（不管是左括号还是右括号）都添加到当前字符串的右边
     * 第二点，如果左括号等于右括号，那么在二叉树中是可以走左子树（也就是可以往字符串中添加'('），如果
     * 左括号小于右括号，那么此时只能往字符串中添加右括号')'。因为这个时候再不往字符串中添加')'就会造成一个
     * 非法的字符，这也是非常重要的。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String cur, int open, int close, int max) {
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
