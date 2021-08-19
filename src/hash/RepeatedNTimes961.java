package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class RepeatedNTimes961 {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int num = 0;
        for (int j : A) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            } else if (map.get(j) + 1 == (A.length >> 1)) {
                num = j;
                break;
            } else {
                map.put(j, map.get(j) + 1);
            }
        }
        return num;
    }
}
