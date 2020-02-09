package string;


/**
 * @author baitao zou
 * date 2020/02/09
 */
public class MyAtoi8 {

    /**
     * 这个题目一直没做，主要是把这个题目想的太难了，其实这个题目把算法步骤在题干中写明白了。
     * 1、找到字符串中首次不为' '的字符，从这个' '字符后面开始解析
     * 2、判断第一个不为空的字符是否是'+','-'，那么我们此时将会从'+'/'-'的下一个字符开始解析，找到
     * 连续的字符串，然后去解析。如果第一个字符串不为'+'/'-'，那么同样找到连续的数字字符串。
     * 3、解析第二步得到的数字，这里主要是给定的字符串会很长，那么我们给定一个max = (long)Integer.MAX_VALUE + 1;
     * 并将max转换成一个字符串，如果，目标字符串大于这个数，那么直接返沪Integer.MAX_VALUE,如果目标字符串小于这个数，
     * 那么直接解析完返回。
     *
     * @param str 目标字符串
     * @return 解析后的有效的数字
     */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        //起始位置的判断空字符串
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        //str= "   "
        if (i == str.length()) {
            return 0;
        }

        char ch = str.charAt(i);

        StringBuilder sb;
        if (ch == '-' || ch == '+') {
            i++;
            if (i == str.length()) {
                return 0;
            }

            sb = validateCharNum(str, i);

            long result = parseLong(sb);
            if (result > Integer.MAX_VALUE) {
                if (ch == '-') {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (ch == '-') {
                    return (int) -result;
                } else {
                    return (int) result;
                }
            }
        }

        if (ch >= '0' && ch <= '9') {
            sb = validateCharNum(str, i);
            long result = parseLong(sb);
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) result;
            }
        }

        return 0;
    }


    /**
     * @param str        字符串
     * @param startIndex 起始位置
     * @return 有效的数字字符串
     */
    private StringBuilder validateCharNum(String str, int startIndex) {
        StringBuilder sb = new StringBuilder();
        while (startIndex < str.length() && str.charAt(startIndex) >= '0' && str.charAt(startIndex) <= '9') {
            sb.append(str.charAt(startIndex));
            startIndex++;
        }
        return sb;
    }

    /**
     * 解析一个有效的字符串数字为龙类型
     *
     * @return long类型数字
     */
    private long parseLong(StringBuilder sb) {
        if (sb.length() == 0) {
            return 0;
        }
        int j = 0;
        while (j < sb.length() && sb.charAt(j) == '0') {
            j++;
        }
        String validString = sb.substring(j, sb.length());

        long max = (long) Integer.MAX_VALUE + 1;
        String longMaxString = String.valueOf(max);

        int cmp = compareStringNum(longMaxString, validString);
        if (cmp <= 0) {
            return max;
        }

        int result = 0;
        int mul = 1;
        for (int i = sb.length() - 1; i >= j; i--) {
            result += (sb.charAt(i) - '0') * mul;
            mul *= 10;
        }
        return result;
    }

    /**
     * 比较两个字符串数字大小，这里的字符串数字都是有效的整数。
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return str1 > str2 ,return 1 ｜ str1 == str2 ,return 0 ｜ str1 < str2 ,return -1
     */
    private int compareStringNum(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return 1;
        }
        if (str1.length() < str2.length()) {
            return -1;
        }
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if (ch1 > ch2) {
                return 1;
            }

            if (ch1 < ch2) {
                return -1;
            }
        }
        return 0;
    }
}
