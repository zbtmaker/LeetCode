package array;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode992:https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）返回 A 中好子数组的数目。
 *
 * @author baitao zou
 * date 2020/05/30
 */
public class SubarraysWithKDistinct992 {
    /**
     * 滑动窗口算法
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysWithKDistinctByOneWindow(A, K);
    }

    private int subarraysWithKDistinctByOneWindow(int[] A, int K) {
        Map<Integer, Integer> numMapCount = new HashMap<>();
        int left = 0, inner = 0, right = 0, size = 0;
        while (right < A.length) {
            int num1 = A[right];
            numMapCount.put(num1, numMapCount.getOrDefault(num1, 0) + 1);
            if (numMapCount.size() == K) {
                int i = left;
                while (numMapCount.size() == K) {
                    size++;
                    int val = numMapCount.get(A[i]) - 1;
                    if (val == 0) {
                        numMapCount.remove(A[i]);
                    } else {
                        numMapCount.put(A[i], val);
                    }
                    i++;
                }
                for (int j = left; j < i; j++) {
                    numMapCount.put(A[j], numMapCount.getOrDefault(A[j], 0) + 1);
                }
            } else {
                while (numMapCount.size() > K) {
                    int num2 = A[left];
                    int val = numMapCount.get(num2) - 1;
                    if (val == 0) {
                        numMapCount.remove(num2);
                    } else {
                        numMapCount.put(num2, val);
                    }
                    left++;
                }
                int i = left;
                while (numMapCount.size() == K) {
                    size++;
                    int val = numMapCount.get(A[i]) - 1;
                    if (val == 0) {
                        numMapCount.remove(A[i]);
                    } else {
                        numMapCount.put(A[i], val);
                    }
                    i++;
                }
                for (int j = left; j < i; j++) {
                    numMapCount.put(A[j], numMapCount.getOrDefault(A[j], 0) + 1);
                }
            }

            right++;
        }
        return size;
    }

    private int subarraysWithKDistinctByTwoWindow(int[] A, int K) {
        return 0;
    }
}
