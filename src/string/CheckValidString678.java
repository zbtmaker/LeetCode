package string;

import java.util.Stack;

/**
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * <p>
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * tag:String、Stack
 *
 * @author baitao zou
 * date 2020/04/04
 */
public class CheckValidString678 {
    /**
     * 这个题目和LongestValidParentheses32是有一些相似之处的，但是我们是不是可以用动态规划的算法来解决。
     * 或者是通过其他的方法来实现。
     * 方法一：Dynamic Programming
     * 方法二：两个Stack实现
     *
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        return checkValidStringByStack(s);
    }

    /**
     * 两个stack都用来记录位置，一个用来记录'('的位置，另一个用来记录'*'的位置,如果我们碰到'('我们就需要将字符所在的位置
     * 添加到bracketIndex这个stack当中，如果字符为'*'，那么此时将位置添加到栈starIndex中。如果碰到')'。首先需要查看
     * bracketIndex和starIndex是否都为空，如果为空，则表示出现了前面的都能正常匹配，这个不行，所以需要报异常。否则就需要
     * 看bracketIndex里买是否为空，如果不为空，则优先从bracketIndex中pop出一个元素。如果bracketIndex为空，则需要拿starIndex
     * 中的元素pop出一个'*'作为一个'('使用。当循环结束时，需要判断我们的bracketIndex是否为空，如果bracketIndex为空，则表明
     * 所有的')'都能匹配上一个'('。如果bracketIndex不为空且starIndex为空，那么表示还有'('没有匹配到')'。如果
     * bracketIndex不为空，且starIndex也不为空，那么最后就是要看startIndex.pop出来的'*'的位置是否在bracketIndex.pop出来的后面。
     * 如果是，则表示'('后面还有'*'可以被当作')'来使用，否则就是匹配失败。最终我们就是要看bracketIndex是否为空，如果空则是合法字符串，
     * 如果不为空，则不是合法字符串。
     *
     * @param s
     * @return
     */
    private boolean checkValidStringByStack(String s) {
        Stack<Integer> bracketsIndex = new Stack<>();
        Stack<Integer> starIndex = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracketsIndex.add(i);
            } else if (s.charAt(i) == '*') {
                starIndex.add(i);
            } else {
                if (bracketsIndex.isEmpty() && starIndex.isEmpty()) {
                    return false;
                }
                if (!bracketsIndex.isEmpty()) {
                    bracketsIndex.pop();
                } else {
                    starIndex.pop();
                }
            }
        }
        while (!bracketsIndex.isEmpty() && !starIndex.isEmpty()) {
            if (bracketsIndex.pop() > starIndex.pop()) {
                return false;
            }
        }
        return bracketsIndex.isEmpty();
    }
}
