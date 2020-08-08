package array;

import java.util.HashMap;

/**
 * @author baitao zou
 * date 2020/08/08
 */
public class Cashier1357 {
    private final int n;
    private final int discount;

    private final HashMap<Integer, Integer> priceMap;

    private int count = 0;

    public Cashier1357(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        priceMap = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            priceMap.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        count++;
        int sum = 0;
        for (int i = 0; i < product.length; i++) {
            sum += priceMap.get(product[i]) * amount[i];
        }

        if (count % n == 0) {
            return sum - ((double)sum * discount) / 100;
        }
        return sum;
    }
}
