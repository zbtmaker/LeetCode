package unionfind;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baitao zou
 * date 2020/03/17
 */
public class RemoveStones947 {

    public int removeStones(int[][] stones) {
        if (stones == null || stones.length <= 1) {
            return 0;
        }
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int count = 0;
        for (int[] stone : stones) {
            if (rowSet.contains(stone[0]) || colSet.contains(stone[1])) {
                count++;
            }
            rowSet.add(stone[0]);
            colSet.add(stone[1]);
        }
        return count;
    }
}
