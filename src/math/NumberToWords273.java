package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zoubaitao
 * date 2022/09/10
 */
public class NumberToWords273 {

    private static final String[] per = new String[]{"", "Thousand", "Million", "Billion"};

    private static final String[] numArr = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    private static final String[] arr = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private static final String[] tenArr = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int res = len / 3;
        int mod = len % 3;
        List<String> sb = new ArrayList<>();
        int i = 0;

        for (; i < res; i++) {
            String str = parseThree(s.substring(len - (i * 3 + 3), len - i * 3));
            if (str.equals("")) {
                continue;
            }
            if (i == 0) {
                sb.add(0, str);
            } else {
                sb.add(0, str + " " + per[i]);
            }
        }

        if (mod != 0) {
            String last = s.substring(0, mod);
            String cur = convert(last);
            if(!cur .equals("")) {
                if(res == 0) {
                    sb.add(0, cur);
                }else {
                    sb.add(0, cur + " " + per[i]);
                }
            }

        }
        if(sb.size() == 0) {
            return "Zero";
        }
        StringBuilder words = new StringBuilder();
        for (int j = 0; j < sb.size(); j++) {
            words.append(sb.get(j));
            if (j != sb.size() - 1) {
                words.append(" ");
            }
        }
        return words.toString();
    }

    private String convert(String str) {
        int len = str.length();
        if (len == 1) {
            return parseOne(str);
        }
        if (len == 2) {
            return parseTwo(str);
        }
        return parseThree(str);
    }

    private String parseOne(String str) {
        if (str.equals("0")) {
            return "";
        }
        return numArr[Integer.parseInt(str) - 1];
    }

    private String parseTwo(String str) {
        char[] chs = str.toCharArray();
        if (chs[0] == '0') {
            return parseOne(str.substring(1));
        }
        if (chs[0] == '1') {
            return arr[Integer.parseInt(str.substring(1))];
        }
        String single = parseOne(str.substring(1));
        if (!single.equals("")) {
            single = " " + single;
        }

        return tenArr[(chs[0] - '0') - 2] + single;
    }

    private String parseThree(String str) {
        char[] chs = str.toCharArray();
        if (chs[0] == '0') {
            return parseTwo(str.substring(1));
        }
        String two = parseTwo(str.substring(1));
        if (!two.equals("")) {
            two = " " + two;
        }
        return numArr[(chs[0] - '0') - 1] + " " + "Hundred" + two;
    }
}
