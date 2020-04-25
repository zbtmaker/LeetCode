package string;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * Created by Administrator on 2019\3\8 0008.
 */
public class Partition131 {
    /**
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new LinkedList<>();
        List<String> list = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return lists;
        }
        recurPartition(s, 0, list, lists);
        return lists;
    }

    private void recurPartition(String s, int index, List<String> list, List<List<String>> lists) {
        if (index >= s.length()) {
            lists.add(new LinkedList<>(list));
            return;
        }
        list.add(s.substring(index, index + 1));
        recurPartition(s, index + 1, list, lists);
        list.remove(list.size() - 1);
        for (int i = index + 1; i < s.length(); i++) {
            String substr = s.substring(index, i + 1);
            if (isPalindrome(substr)) {
                list.add(substr);
                recurPartition(s, i + 1, list, lists);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
