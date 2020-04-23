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
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Map<String, String> map = new HashMap<String, String>();
        int sum = 0;
        for (int i = 0; i < candidates.length; i++) {
            sum += candidates[i];
            ArrayList<Integer> array = new ArrayList<Integer>();
            array.add(candidates[i]);
            combinationSumI(candidates, target, sum, i + 1, list, array, map);
            sum = 0;
        }
        return list;
    }

    private void combinationSumI(int[] candidates, int target,
                                 int sum, int index, List<List<Integer>> list,
                                 ArrayList<Integer> array, Map<String, String> map) {
        if (sum == target) {
            ArrayList<Integer> arrayList = new ArrayList<>(array);
            Collections.sort(arrayList);

            if (!map.containsKey(arrayList.toString())) {
                map.put(arrayList.toString(), "string");
                list.add(new ArrayList<Integer>(array));
            }
            return;
        }
        if (sum < target) {
            for (int i = index; i < candidates.length; i++) {
                sum += candidates[i];
                array.add(candidates[i]);
                combinationSumI(candidates, target, sum, i + 1, list, array, map);
                array.remove(array.size() - 1);
                sum -= candidates[i];
            }
        }
    }

    /**
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        int sum = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            ArrayList<Integer> array = new ArrayList<Integer>();
            array.add(candidates[i]);
            combinationSumII(candidates, target, sum, i + 1, list, array);
            sum = 0;
        }
        return list;
    }

    private void combinationSumII(int[] candidates, int target,
                                  int sum, int index, List<List<Integer>> list,
                                  ArrayList<Integer> array) {
        if (sum == target) {
            list.add(new ArrayList<Integer>(array));
            return;
        }
        if (sum < target) {
            for (int i = index; i < candidates.length; i++) {
                sum += candidates[i];
                array.add(candidates[i]);
                combinationSumII(candidates, target, sum, i + 1, list, array);
                array.remove(array.size() - 1);
                sum -= candidates[i];
            }
        }

    }
}
