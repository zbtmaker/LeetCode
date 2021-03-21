package hash;


import java.util.ArrayDeque;

/**
 * @author Baitao Zou
 * date 2019\1\29 0029.
 */
public class DailyTemperatures739 {

    public int[] dailyTemperatures(int[] T) {
        return dailyTemperaturesQueue(T);
    }

    /**
     * 双指针循环方式
     *
     * @param T
     * @return
     */
    private int[] dailyTemperaturesBruteForce(int[] T) {
        int[] raise = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    raise[i] = j - i;
                    break;
                }
            }
        }
        return raise;
    }

    /**
     * 采用单调队列的方式解决，采用单调队列的方式，一旦遇到一个比队列中更大的元素，从队尾将元素删除，直到队列中所有元素都比当前元素要大。
     *
     * @param T 温度数组
     * @return
     */
    private int[] dailyTemperaturesQueue(int[] T) {
        int len = T.length;
        int[] raise = new int[len];
        WindowQueue windowQueue = new WindowQueue();
        for (int i = len - 1; i > -1; i--) {
            raise[i] = windowQueue.push(T[i], i);
        }
        return raise;
    }

    private class WindowQueue {
        private ArrayDeque<Position> deque;

        WindowQueue() {
            this.deque = new ArrayDeque<>();
        }

        public int push(int temperature, int index) {
            while (!deque.isEmpty() && deque.peekLast().temperature <= temperature) {
                deque.pollLast();
            }
            if (deque.isEmpty()) {
                deque.addLast(new Position(temperature, index));
                return 0;
            }
            int day = deque.peekLast().index - index;
            deque.addLast(new Position(temperature, index));
            return day;
        }
    }

    private class Position {
        private int temperature;
        private int index;

        Position(int temperature, int index) {
            this.temperature = temperature;
            this.index = index;
        }
    }
}
