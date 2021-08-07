package string;

/**
 * @author baitao zou
 * date 2020/04/16
 */
public class IsScramble87 {

    public boolean isScramble(String s1, String s2) {
        return isScrambleByBruteForce(s1, s2);
    }

    /**
     * 采用暴力的方式来判断
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScrambleByBruteForce(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            String leftS1 = s1.substring(0, i + 1);
            String rightS1 = s1.substring(i + 1, len);
            String leftS2 = s2.substring(0, i + 1);
            String rightS2 = s2.substring(i + 1, len);
            if (isomerism(leftS1, leftS2) && isomerism(rightS1, rightS2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断两个字符串是否是异构的
     *
     * @param s1
     * @param s2
     * @return
     */
    private boolean isomerism(String s1, String s2) {
        return false;
    }

}
