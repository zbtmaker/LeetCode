package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\1\22 0022.
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combine77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new LinkedList<>();
        combine(n, k, 1, 0, list, new LinkedList<>());
        return list;
    }

    public void combine(int n, int k, int index, int count,
                        List<List<Integer>> list, LinkedList<Integer> array) {
        if (count == k) {
            list.add(new ArrayList<>(array));
            return;
        }
        for (int j = index; j <= n; j++) {
            array.add(j);

            count++;
            combine(n, k, j + 1, count, list, array);
            array.removeLast();
            count--;
        }
    }
}
