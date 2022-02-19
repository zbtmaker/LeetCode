package array;

import java.util.Arrays;

/**
 * @author zoubaitao
 * date 2019/02/26
 */
public class SumEvenAfterQueries985 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[queries.length];
        int sum = Arrays.stream(A).filter(num -> (num & 1) == 0).sum();

        for (int j = 0; j < queries.length; j++) {
            int tmp = A[queries[j][1]] + queries[j][0];
            int after = tmp & 1, before = A[queries[j][1]] & 1;
            if (before != 0) {
                if (after == 0) {
                    sum += tmp;
                }
            } else {
                if (after == 0) {
                    sum += queries[j][0];
                } else {
                    sum -= A[queries[j][1]];
                }
            }
            result[j] = sum;
            A[queries[j][1]] = A[queries[j][1]] + queries[j][0];
        }
        return result;
    }
}
