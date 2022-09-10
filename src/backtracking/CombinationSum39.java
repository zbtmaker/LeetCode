package backtracking;

import java.util.*;

/**
 * Created by Administrator on 2019\1\20 0020.
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 下面将这个题目分为两种情况：
 * (I)在数组中没有重复的元素，但是每一个元素都可以重复利用：代码如combinationI
 * (II)在数组中有重复元素，但是每一个元素只能利用一次。
 * 解题思路和变种问题：组合问题需要做的是输出组合的某一种或者是所有的组合，
 * 另一种情况就是输出所有组合的总数，这里只不过是硬币种类多了一些。
 */
public class CombinationSum39 {
    /**
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSumI(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        combinationSumI(candidates, target, 0, list, new LinkedList<Integer>(), new HashSet<>());
        return list;
    }

    private void combinationSumI(int[] candidates, int target, int index, List<List<Integer>> list,
                                 LinkedList<Integer> array, HashSet<List<Integer>> map) {
        if (target == 0) {
            if (!map.contains(array)) {
                List<Integer> tmp = new LinkedList<>(array);
                map.add(tmp);
                list.add(tmp);
            }
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            target -= candidates[i];
            array.add(candidates[i]);
            combinationSumI(candidates, target, i, list, array, map);
            array.removeLast();
            target += candidates[i];
        }
    }
}
