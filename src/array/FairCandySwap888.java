package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019\1\19 0019.
 */
public class FairCandySwap888 {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        HashMap<Integer, List<Integer>> aValueMapIndex = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
            List<Integer> list = aValueMapIndex.computeIfAbsent(A[i], k -> new ArrayList<>());
            list.add(i);
        }

        int sumB = 0;
        HashMap<Integer, List<Integer>> bValueMapIndex = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
            List<Integer> list = bValueMapIndex.computeIfAbsent(B[i], k -> new ArrayList<>());
            list.add(i);
        }

        int average = (sumA + sumB) >> 1;

        int[] result = new int[2];
        for (int i = 0; i < A.length; i++) {
            List<Integer> indexList = bValueMapIndex.get(sumA - A[i] - average);
            if (indexList != null) {
                result[0] = i;
                result[1] = indexList.get(0);
                return result;
            }
        }
        return result;
    }
}
