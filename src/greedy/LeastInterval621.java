package greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baitao zou
 * date 2020/05/04
 */
public class LeastInterval621 {
    private final Map<Character, Integer> map = new HashMap<>();

    public int leastInterval(char[] tasks, int n) {
        for (char ch : tasks) {
            map.merge(ch, 1, Integer::sum);
        }

        return 0;
    }
}
