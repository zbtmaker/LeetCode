package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class CombinationSumIII216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        combinationSum3(k, n, 0, 0, 1, lists, new ArrayList<>());
        return lists;
    }

    public void combinationSum3(int k, int n, int count, int sum, int index,
                                List<List<Integer>> lists, List<Integer> arrayList) {
        if (sum == n && count == k) {
            lists.add(new ArrayList<>(arrayList));
            return;
        }
        if (sum > n || count > k) {
            return;
        }
        for (int i = index; i <= n; i++) {
            if (i > 9) {
                break;
            }
            sum += i;
            count++;
            arrayList.add(i);
            combinationSum3(k, n, count, sum, i + 1, lists, arrayList);
            arrayList.remove(arrayList.size() - 1);
            sum -= i;
            count--;
        }
    }
}
