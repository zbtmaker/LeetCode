package string;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author baitao zou
 * date 2020/02/09
 */
public class LexicalOrder386 {
    /**
     * 这个题目和之前的方式还真是有些不同。这个题目并不像我们想象的那么简单。这个题目思路是DFS，而且使用递归的方式实现会更好。
     * 当我们给定一个数的时候，例如给定n = 1010，那么这个时候从1 ->10 -> 100 -> 1000的顺序放入到Stack当中，在添加到Stack的同时
     * 也需要List当中。当Stack执行pop方法时不需要添加到List当中。
     * 从下一个数1000+1 = 1001开始进行递归，然后发现1001->10010时，10010>n,因此退出当前递归。进行下一个递归，1000+2 = 1002
     * 这个时候和之前的1001一样，这种情况一直到1009。这个时候我们得到了一个序列。1、100、1000、1001、1002、1003、1004、1005、
     * 1006、1007、1008、1009。此时1000已经从stack中弹出了。所以从Stack中弹出100，并从101开始进行递归，和上面的1000执行过程是
     * 一样的。
     *
     * @param n 给定范围内的数字按字符串进行排序
     * @return 排序的数字字符串
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= 9 && i <= n; i++) {
            result.add(i);
            recursive(i * 10, n, result);
        }
        return result;
    }

    /**
     * @param num    数字开始时间
     * @param n      数字范围区间
     * @param result 字符串数字排序结果
     */
    private void recursive(int num, int n, List<Integer> result) {
        Stack<Integer> stack = new Stack<>();
        while (num <= n) {
            result.add(num);
            stack.push(num);
            num = num * 10;
        }
        while (!stack.isEmpty()) {
            int val = stack.pop();
            for (int j = val + 1; j < val + 10 && j <= n; j++) {
                result.add(j);
                recursive(j * 10, n, result);
            }
        }
    }
}
