package string;

/**
 * @author zoubaitao
 * date 2022/02/25
 */
public class IsNumber65 {
    private final static char PLUS = '+';

    private final static char MINUS = '-';

    private final static char DOT = '.';

    /**
     * 这个题目的难点就在于要思考四种字符串前面和后面能出现什么样的字符串，
     * 这个才是最难的，
     * 1、对于一个字符串数值，肯定是字符串中要包含数字
     * 2、'e'字符最多在字符串中出现1次，不能出现在字符串开头和结尾，e字符前面一个字符不能是'+'、'-',如果是'.'，那么.前面一定是一个合法数字。
     * 3、'+'字符最多在字符串中出现1次，要么出现在字符串的第一位，要么跟在'e'字符的后面，不能出现在字符串的末尾。
     * 4、'-'字符最多在字符串中出现1次，要么出现在字符串的第一位，要么跟在'e'字符的后面，不能出现在字符串的末尾。
     * 5、'.'字符最多在字符串中出现1次，不能出现在'e'字符的后面，只能在e字符的前面。
     * 6、其他字符一旦出现，则视为非法字符
     *
     * @param s 字符数字
     * @return true-合法数值，false-非法数值
     */
    public boolean isNumber(String s) {
        int len = s.length();
        if (len < 1 || s.charAt(0) == 'e' || s.charAt(0) == 'E' ||
                s.charAt(len - 1) == 'e' || s.charAt(len - 1) == 'E'
                || s.charAt(len - 1) == PLUS || s.charAt(len - 1) == MINUS
                || (len == 1 && (s.charAt(0) > '9' || s.charAt(0) < '0'))) {
            return false;
        }

        int eCount = 0, dotCount = 0, plusCount = 0, minusCount = 0, numCount = 0;
        char last = ' ';
        int i = 0;
        while (i < len) {
            char cur = s.charAt(i);
            if (cur == DOT) {
                dotCount++;
                if (dotCount > 1 || eCount > 0) {
                    return false;
                }
            } else if (cur == 'e' || cur == 'E') {
                eCount++;
                if (eCount > 1 || (last == DOT && numCount == 0) ||
                        last == PLUS || last == MINUS) {
                    return false;
                }
            } else if (cur == PLUS) {
                plusCount++;
                if (plusCount > 2 || (i != 0 && last != 'e' && last != 'E')) {
                    return false;
                }
            } else if (cur == MINUS) {
                minusCount++;
                if (minusCount > 2 || (i != 0 && last != 'e' && last != 'E')) {
                    return false;
                }
            } else if (cur >= '0' && cur <= '9') {
                numCount++;
            } else {
                return false;
            }
            last = cur;
            i++;
        }

        return numCount > 0;
    }
}
