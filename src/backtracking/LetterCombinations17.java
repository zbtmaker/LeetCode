package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zoubaitao
 * date 2019/2/2
 */
public class LetterCombinations17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return null;
        }
        List<String> list = new ArrayList<>();
        String[] strings = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            strings[i] = charToWords(digits.charAt(i) - '0');
        }
        for (int i = 0; i < strings[0].length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strings[0].charAt(i));
            letterCombinations(strings, list, sb, 1);
        }
        return list;
    }

    private void letterCombinations(String[] strings, List<String> list,
                                    StringBuilder sb, int index) {
        if (index == strings.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < strings[index].length(); i++) {
            sb.append(strings[index].charAt(i));
            letterCombinations(strings, list, sb, index + 1);
            sb.deleteCharAt(index);
        }
    }

    public String charToWords(int i) {
        String s;
        switch (i) {
            case 2:
                s = "abc";
                break;
            case 3:
                s = "def";
                break;
            case 4:
                s = "ghi";
                break;
            case 5:
                s = "jkl";
                break;
            case 6:
                s = "mno";
                break;
            case 7:
                s = "pqrs";
                break;
            case 8:
                s = "tuv";
                break;
            case 9:
                s = "wxyz";
                break;
            default:
                return null;
        }
        return s;
    }
}
