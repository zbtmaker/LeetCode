package array;

import java.util.ArrayDeque;

/**
 * @author Baitao Zou
 * date 2021/03/21
 */
public class StockSpanner901 {
    private ArrayDeque<Pair> arrayDeque;

    public class Pair {
        int price;
        int count;

        Pair(int price, int count) {
            this.price = price;
            this.count = count;
        }
    }

    StockSpanner901() {
        arrayDeque = new ArrayDeque<>();
    }

    public int next(int price) {
        int count = 1;
        while (!arrayDeque.isEmpty() && arrayDeque.peekLast().price <= price) {
            count += arrayDeque.pollLast().count;
        }
        arrayDeque.addLast(new Pair(price, count));
        return count;
    }
}
