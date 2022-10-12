package array;

/**
 * @author zoubaitao
 * date 2022/10/12
 */
public class GetDescentPeriods2110 {
    public long getDescentPeriods(int[] prices) {
        int len = prices.length;
        long res = len;
        int i = 0;
        while(i < len) {
            int k = i + 1;
            while(k < len && prices[k] + 1 == prices[k - 1]) {
                k++;
            }
            res += (long) (k - 1 - i) *(k - i)/ 2;
            i = k;
        }
        return res;
    }
}
