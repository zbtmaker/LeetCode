package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zoubaitao
 * date 2022/09/10
 */
public class CombinationSumII40 {

    /**
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(candidates);
        combinationSumII(candidates, target, 0, list, new LinkedList<>());
        return list;
    }

    private void combinationSumII(int[] candidates, int target,
                                  int index, List<List<Integer>> result,
                                  LinkedList<Integer> array) {
        if (0 == target) {
            result.add(new ArrayList<>(array));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 提前剪枝
            if (target - candidates[i] < 0) {
                break;
            }
            // 同一层不能选择两个相同的候选人
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            array.add(candidates[i]);
            combinationSumII(candidates, target - candidates[i], i + 1, result, array);
            array.removeLast();
        }
    }
}
