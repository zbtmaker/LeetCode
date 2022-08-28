package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zoubaitao
 * date 2022/08/27
 */
public class MaxEnvelopes354 {
    /**
     * 1、我们将envelopes数组转换成一个对象，然后添加到链表中
     * 2、根据width域从低到高排序，这时链表中的已经是一个有序的集合了，只不过针对width是有序的
     * 3、我们其实就是要找到height一直上升的序列，因为width是从小到大排序的，因此这个题目就
     * 退化成根据height的最长上升子序列，因此我们就可以利用最长上升子序列的动态规划思路来解决这个问题
     * 时间复杂度O(N^2), 空间复杂度O(N)
     *
     * @param envelopes 信封数组
     * @return 最多能有多少个信封撞到同一个信封
     */
    public int maxEnvelopes(int[][] envelopes) {
        // 将信封按照width先排序，如果width相等的情况下，按照height大小倒排；
        Arrays.sort(envelopes, (o1, o2) -> o1[0] != o2[0]
                ? o1[0] - o2[0]
                : o2[1] - o1[1]);
        return maxEnvelopesByBinarySearch(envelopes);
    }

    private int maxEnvelopesByDP(int[][] envelopes) {
        int len = envelopes.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            int tmp = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][1] > envelopes[j][1] && dp[j] + 1 > tmp) {
                    tmp = dp[j] + 1;
                }
            }
            dp[i] = tmp;
            max = Math.max(max, tmp);
        }
        return max;
    }

    /**
     * @param envelopes
     * @return
     */
    private int maxEnvelopesByBinarySearch(int[][] envelopes) {
        List<Integer> aux = new ArrayList<>();
        aux.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > aux.get(aux.size() - 1)) {
                aux.add(envelopes[i][1]);
            } else {
                int index = findMinIndex(envelopes[i][1], aux);
                aux.set(index, envelopes[i][1]);
            }
        }
        return aux.size();
    }

    private int findMinIndex(int num, List<Integer> aux) {
        int left = 0;
        int right = aux.size() - 1;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (aux.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
