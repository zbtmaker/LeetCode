package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Baitao Zou
 * date 2021/01/02
 */
public class LeastInterval621 {
    class Node {
        char key;
        int val;
    }

    public int leastInterval(char[] tasks, int n) {
        List<Node> list = getTaskFrequency(tasks);


        return 0;
    }

    private List<Node> getTaskFrequency(char[] tasks) {
        Map<Character, Integer> charMapCount = new HashMap<>();
        for (char task : tasks) {
            charMapCount.put(task, charMapCount.getOrDefault(task, 0) + 1);
        }
        return charMapCount.entrySet().stream().map(entry -> {
            Node node = new Node();
            node.key = entry.getKey();
            node.val = entry.getValue();
            return node;
        }).sorted((o1, o2) -> Integer.compare(o2.val, o1.val)).collect(Collectors.toList());
    }
}
