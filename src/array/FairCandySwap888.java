package array;

import java.util.HashSet;

/**
 * Created by Administrator on 2019\1\19 0019.
 */
public class FairCandySwap888 {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        for (int j : A) {
            sumA += j;
        }

        int sumB = 0;
        HashSet<Integer> bValueSet = new HashSet<>();
        for (int j : B) {
            sumB += j;
            bValueSet.add(j);
        }

        int average = (sumA + sumB) >> 1;

        int[] result = new int[2];
        for (int i = 0; i < A.length; i++) {
            int valA = sumA - A[i];
            if (valA > average) {
                continue;
            }
            if (bValueSet.contains(average - valA)) {
                result[0] = A[i];
                result[1] = average - valA;
                return result;
            }
        }
        return result;
    }
}
