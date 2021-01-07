package dp;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author baitao zou
 * date 2020/05/11
 */
public class ShoppingOffers638 {

    /**
     * 其实这个就是硬币兑换题目的变种，回溯算法解决零钱兑换问题，零钱可以无限使用。但是这里有很多维，如果用回溯算法解决的话，时间复杂度很容易爆炸。
     * 也考虑过使用Simplex Method解决这类问题，但是发现Simplex Method只适用于解连续性问题，无法解决0-1整数规划问题。
     *
     * @param price
     * @param special
     * @param needs
     * @return
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        initSinglePackage(price, special);
        Map<List<Integer>, Integer> needsMapCost = new HashMap<>();
        List<Integer> zeroNeeds = Stream.generate(() -> 0).limit(needs.size()).collect(Collectors.toList());
        needsMapCost.put(zeroNeeds, 0);
        return shoppingOffersByMemorization(special, needs, needsMapCost);
    }

    /**
     * 记忆划递归，就是一种自顶向下的递归，但是会记录下每个needs下的计算的结果。也就是说我们的不同的
     * needs分解到下一个
     *
     * @param special
     * @param needs
     * @return
     */
    private int shoppingOffersByMemorization(List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> needsMapCost) {
        Integer minCost = needsMapCost.get(needs);
        if (minCost != null) {
            return minCost;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < special.size(); i++) {
            List<Integer> pack = special.get(i);
            List<Integer> newNeeds = minusNeeds(pack, needs);
            if (newNeeds == null) {
                continue;
            }
            int cost = pack.get(pack.size() - 1);
            cost += shoppingOffersByMemorization(special, newNeeds, needsMapCost);
            min = Math.min(cost, min);
        }
        needsMapCost.put(needs, min);
        return min;
    }

    /**
     * 其实这个就是硬币兑换题目的变种，回溯算法解决零钱兑换问题，零钱可以无限使用。但是这里有很多维，如果用回溯算法解决的话，时间复杂度很容易爆炸。
     * 也考虑过使用Simplex Method解决这类问题，但是发现Simplex Method只适用于解连续性问题，无法解决0-1整数规划问题。
     *
     * @param special
     * @param needs
     * @return
     */
    private int shoppingOffersByBacktracking(List<List<Integer>> special, List<Integer> needs) {
        if (needsEqualZero(needs)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < special.size(); i++) {
            List<Integer> pack = special.get(i);
            List<Integer> newNeeds = minusNeeds(pack, needs);
            if (newNeeds == null) {
                continue;
            }
            int cost = pack.get(pack.size() - 1);
            cost += shoppingOffersByBacktracking(special, newNeeds);
            min = Math.min(cost, min);
        }
        return min;
    }

    /**
     * 修改需求量
     *
     * @param pack  当前包裹
     * @param needs 当前迭代需求
     */
    private List<Integer> minusNeeds(List<Integer> pack, List<Integer> needs) {
        List<Integer> newNeeds = new ArrayList<>(needs.size());
        for (int i = 0; i < needs.size(); i++) {
            int need = needs.get(i) - pack.get(i);
            if (need < 0) {
                return null;
            }
            newNeeds.add(need);
        }
        return newNeeds;
    }

    /**
     * @param needs 当前迭代需求
     * @return 如果needs所有的需求为0，则返回true，否则返回false
     */
    private boolean needsEqualZero(List<Integer> needs) {
        return needs.stream().allMatch(i -> i == 0);
    }

    /**
     * 初始化单个的大礼包，每个单价出售的物品都可以看作是一个只包含一个商品的礼包
     *
     * @param price 商品价格
     */
    private void initSinglePackage(List<Integer> price, List<List<Integer>> special) {
        int size = price.size();
        for (int i = 0; i < size; i++) {
            List<Integer> cur = Stream.generate(() -> 0).limit(size).collect(Collectors.toList());
            cur.set(i, 1);
            cur.add(price.get(i));
            special.add(cur);
        }
    }

}
