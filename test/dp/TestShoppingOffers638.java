package dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/05/12
 */
public class TestShoppingOffers638 {

    private ShoppingOffers638 shopping = new ShoppingOffers638();

    @Test
    public void test1() {
        List<Integer> price = new ArrayList<>(Arrays.asList(2, 5));
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(3, 0, 5));
        special.add(Arrays.asList(1, 2, 10));
        List<Integer> needs = new ArrayList<>(Arrays.asList(3, 2));
        int min = shopping.shoppingOffers(price, special, needs);
        Assert.assertEquals(min, 14);
    }

    @Test
    public void test2() {
        List<Integer> price = new ArrayList<>(Arrays.asList(2, 3, 4));
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(1, 1, 0, 4));
        special.add(Arrays.asList(2, 2, 1, 9));
        List<Integer> needs = new ArrayList<>(Arrays.asList(1, 2, 1));
        int min = shopping.shoppingOffers(price, special, needs);
        Assert.assertEquals(min, 11);
    }

    @Test
    public void test3() {
        List<Integer> price = new ArrayList<>(Arrays.asList(4, 3, 2, 9, 8, 8));
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(1, 5, 5, 1, 4, 0, 18));
        special.add(Arrays.asList(3, 3, 6, 6, 4, 2, 32));
        List<Integer> needs = new ArrayList<>(Arrays.asList(6, 5, 5, 6, 4, 1));
        int min = shopping.shoppingOffers(price, special, needs);
        Assert.assertEquals(min, 91);
    }
}
