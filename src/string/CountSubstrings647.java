package string;

/**
 * Created by Administrator on 2019\1\23 0023.
 */
public class CountSubstrings647 {
    public int countSubstrings(String s) {
        int[] radius = Manacher.manacher(s);
        int sum = 0;
        for (int j : radius) {
            sum += j >> 1;
        }
        return sum;
    }
}
