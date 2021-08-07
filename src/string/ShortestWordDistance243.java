package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baitao zou
 * date 2020/11/28
 */
public class ShortestWordDistance243 {

    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> list = map.computeIfAbsent(word, k -> new ArrayList<>());
            list.add(i);
        }
        List<Integer> position1 = map.get(word1);
        List<Integer> position2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for (Integer pos1 : position1) {
            for (Integer pos2 : position2) {
                min = Math.min(min, Math.abs(pos1 - pos2));
            }
        }
        return min;
    }

}
