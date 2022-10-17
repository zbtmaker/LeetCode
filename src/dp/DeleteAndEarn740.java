package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zoubaitao
 * date 2022/10/12
 */
public class DeleteAndEarn740 {
    /**
     * 这个题目我第一时间想到的就是使用穷举的方式，
     *
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, num);
        }
        int[] arr = new int[max + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            arr[entry.getKey()] = key * entry.getValue();
        }
        int[] F = new int[max + 2];
        Arrays.fill(F, -1);
        return dfs(arr, 0, F);
    }

    private int dfs(int[] arr, int index, int[] F) {
        if (index >= arr.length) {
            return 0;
        }
        int max = F[index];
        if (max != -1) {
            return max;
        }
        max = Math.max(dfs(arr, index + 1, F), dfs(arr, index + 2, F) + arr[index]);
        F[index] = max;
        return max;
    }


}
