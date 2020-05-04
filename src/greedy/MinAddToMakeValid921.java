package greedy;

import java.util.Stack;

/**
 * @author baitao zou
 * date 2020/05/04
 */
public class MinAddToMakeValid921 {

    /**
     * 这个题目其实怎么说呢，也算不上是Middle难度的题，就是Easy级别的题。
     * 最简单的方式就是借用Stack的方式实现，当然这里的算法time complexity O(N),
     * space complexity O(1)
     *
     * @param S
     * @return
     */
    public int minAddToMakeValid(String S) {
        return minAddToMakeValidByCount(S);
    }

    /**
     * 采用Stack思想解决问题，遇到'('则加入stack，遇到')'则从stack中pop出一个元素。
     * 如果遇到')'，但是stack是empty的，那么此时表明是非法的字符串。最后如果stack非empty，
     * 那么表示有'('有没有匹配上的')'，这时需要加上stack的size。
     *
     * @param S
     * @return
     */
    private int minAddToMakeValidByStack(String S) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }
        return count + stack.size();
    }

    /**
     * 不用stack，也就是算法时间复杂度不便，但是空间复杂度变为O(1)。我们用left表示
     * '('未匹配')'的数量，right表示')'未匹配上'('的数量，一旦遇见'('，首先我们看left
     * 是否等于0，如果等于零，则表示')'左边没有字符串，那么此时就没有匹配上，需要补字符串。
     * 循环结束后，我们需要用left + right来表示需要补全的字符数
     *
     * @param S
     * @return
     */
    private int minAddToMakeValidByCount(String S) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left++;
            } else {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        return left + right;
    }
}
