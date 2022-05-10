package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zoubaitao
 * date 2022/03/10
 */
public class AddOperators282 {

    private static final String ADD = "+";

    private static final String MUL = "*";

    private static final String MINUS = "-";

    public List<String> addOperators(String num, int target) {
        return addOperatorsByRecur(num, target);
    }

    private List<String> addOperatorsByRecur(String num, int target) {
        List<String> result = new LinkedList<>();

        return result;
    }

    private void recur(String num, int index, int last, int sum, int target,
                       LinkedList<String> sb, List<String> result) {
        if (index == num.length()) {
            if (sum == target) {
                result.add(listToStr(sb));
            }
            return;
        }
        int cur = 0;
        for (int i = index; i < num.length(); i++) {
            cur = cur * 10 + (num.charAt(i) - '0');
            // 执行'+'
            sb.add(ADD + cur);
            recur(num, i + 1, cur, sum + last, target, sb, result);
            sb.removeLast();

            // 执行'-'
            sb.add(MINUS + cur);
            recur(num, i + 1, -cur, sum + last, target, sb, result);
            sb.removeLast();

            // 执行'*'
            sb.add(MUL + cur);
            recur(num, i + 1, last * cur, sum, target, sb, result);
            sb.removeLast();
        }
    }

    private String listToStr(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}
