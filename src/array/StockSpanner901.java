package array;

import java.util.ArrayDeque;

/**
 * @author Baitao Zou
 * date 2021/03/21
 */
public class StockSpanner901 {
    private ArrayDeque<Position> arrayDeque;

    public class Position {
        int price;
        int count;

        public Position(int price, int count) {
            this.price = price;
            this.count = count;
        }
    }

    public StockSpanner901() {
        arrayDeque = new ArrayDeque<>();
    }

    public int next(int price) {
        int count = 1;
        while (!arrayDeque.isEmpty() && arrayDeque.peekLast().price <= price) {
            count += arrayDeque.pollLast().count;
        }
        arrayDeque.addLast(new Position(price, count));
        return count;
    }
}
