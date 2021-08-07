package array;

/**
 * @author Baitao Zou
 * date 2021/02/23
 */
public class MaxSatisfied1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int[] aux1 = new int[len + 1];
        int[] aux2 = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            aux1[i] = aux1[i - 1] + customers[i - 1];
            aux2[i] = aux2[i - 1] + (1 - grumpy[i - 1]) * customers[i - 1];
        }
        int ret = 0;
        for (int j = X; j <= len; j++) {
            int a1 = aux1[j] - aux1[j - X];
            int a2 = aux2[j] - aux2[j - X];
            ret = Math.max(ret, aux2[len] - a2 + a1);
        }
        return ret;
    }
}
