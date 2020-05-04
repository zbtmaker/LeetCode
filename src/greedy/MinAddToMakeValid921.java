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
}
