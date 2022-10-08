package dp;

import java.util.HashSet;

/**
 * @author zoubaitao
 * date 2022/10/07
 */
public class RemoveBoxes546 {

    public int removeBoxes(int[] boxes) {
        return dfs(boxes, new HashSet<>());
    }

    private int dfs(int[] boxes, HashSet<Integer> indexSet) {
        if (indexSet.size() == boxes.length) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < boxes.length; i++) {
            if (indexSet.contains(i)) {
                continue;
            }
            int count = 1;
            HashSet<Integer> curIndexSet = new HashSet<>();

            int left = i - 1;
            while (left >= 0 && (indexSet.contains(left) || boxes[left] == boxes[i])) {
                if (!indexSet.contains(left)) {
                    curIndexSet.add(left);
                    count++;
                }
                left--;
            }
            int right = i + 1;
            while (right < boxes.length && (indexSet.contains(right) || boxes[right] == boxes[i])) {
                if (!indexSet.contains(right)) {
                    curIndexSet.add(right);
                    count++;
                }
                right++;
            }
            curIndexSet.add(i);
            indexSet.addAll(curIndexSet);
            max = Math.max(max, count * count + dfs(boxes, indexSet));
            indexSet.removeAll(curIndexSet);
        }
        return max;
    }

}
