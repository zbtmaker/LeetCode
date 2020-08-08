package string;

/**
 * @author baitao zou
 * date 2020/08/08
 */
public class DetectCapitalUse520 {

    /**
     * 很直观的想法就是采用大小写字母统计数量来实现，所以这个就很简单
     * @param word 字符
     * @return true-大写字符 false-不符合规则
     */
    public boolean detectCapitalUse(String word) {
        int large = 0, small = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                large++;
            } else if (ch >= 'a' && ch <= 'z') {
                small++;
            }

        }
        if (large == word.length()) {
            return true;
        }
        if (small == word.length()) {
            return true;
        }
        return large == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
    }
}
