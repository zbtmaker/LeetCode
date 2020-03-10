package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/03/10
 */
public class CanVisitAllRooms841 {

    private final static int START = 0;

    /**
     * we use breadth first algorithm solve this problem.
     *
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] marked = new boolean[rooms.size()];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.push(START);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> adjRooms = rooms.get(cur);
            if (adjRooms.isEmpty()) {
                marked[cur] = true;
                continue;
            }
            for (int room : adjRooms) {
                if (!marked[room]) {
                    queue.add(room);
                }
            }
            marked[cur] = true;
        }
        for (boolean mark : marked) {
            if (!mark) {
                return false;
            }
        }
        return true;
    }
}
