package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\2 0002.
 */
public class LetterCasePermutation784 {

    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<String>();
        letterCasePermutation(S, list, new StringBuilder(S.length()), 0);
        return list;
    }

    private void letterCasePermutation(String S, List<String> list, StringBuilder sb, int index) {
        if (index == S.length()) {
            list.add(sb.toString());
            return;
        }
        if (S.charAt(index) >= 'a' && S.charAt(index) <= 'z') {
            sb.append(S.charAt(index));
            letterCasePermutation(S, list, sb, index + 1);
            sb.deleteCharAt(index);
            sb.append((char) (S.charAt(index) - 32));
            letterCasePermutation(S, list, sb, index + 1);
            sb.deleteCharAt(index);
        } else if (S.charAt(index) >= 'A' && S.charAt(index) <= 'Z') {
            sb.append(S.charAt(index));
            letterCasePermutation(S, list, sb, index + 1);
            sb.deleteCharAt(index);
            sb.append((char) (S.charAt(index) + 32));
            letterCasePermutation(S, list, sb, index + 1);
            sb.deleteCharAt(index);
        } else {
            sb.append(S.charAt(index));
            letterCasePermutation(S, list, sb, index + 1);
            sb.deleteCharAt(index);
        }
    }
}
