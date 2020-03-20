package string;

/**
 * @author baitao zou
 * date 2020/03/12
 */
public class NumSimilarGroups839 {

    private static final int DIFF = 2;

    public int numSimilarGroups(String[] A) {
        return numSimilarGroupsByBruteForce(A);
    }

    /**
     * we use brute force method to solve this problem, the time complexity is O(N^2),
     * space complexity is O(1).
     *
     * @param A
     * @return
     */
    private int numSimilarGroupsByBruteForce(String[] A) {
        if (A == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (compareString(A[i], A[j])) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private boolean compareString(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length() || str1.equals(str2)) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
            if (count > DIFF) {
                return false;
            }
        }
        return count == DIFF;
    }
}
