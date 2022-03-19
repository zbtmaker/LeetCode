package dp;

import java.math.BigInteger;
import java.util.*;

/**
 * @author zoubaitao
 * date 2022/02/22
 */
public class NumberOfGoodSubsets1994 {

    private final static int[] PRIME_NUMBER = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    private final static int MAX_NUMBER = 30;

    private final static int MOD = 1000000007;

    /**
     * 好子集定义：如果 nums 的一个子集中，所有元素的乘积可以表示为一个或多个互不相同的质数的乘积，那么我们称它为好子集。
     * 1、我们首先统计数组nums中每个数字出现的频次，
     * <p>
     * 2、数字1是可以添加1个或者多个到好子集中。假设数字1出现的次数为n，如果我们的好子集中不出现1，那么C(n,0) 如果好子集中出现1，
     * 那么这是一个组合数学C(n,1) + C(n,2) + ...+ C(n,n)，那么对于总的组合数为C(n,0) + C(n,1) + C(n,2) + ...+ C(n,n) = 2^n。
     * <p>
     * 3、对于其中其他的质数，在每一个好子集中只能出现一次，比方说质数2，如果在nums数组中出现的次数为k，那么好子集出如果选择了2，可以出现的频次为
     * <p>
     * 4、这个题目到这里就变成了Subset78题。
     * <p>
     * 这个题目最坑的就是计算的数据过大，只能借助BigInteger来计算了，我太难了。
     *
     * @param nums 数组
     * @return 好子数集的总数
     */
    public int numberOfGoodSubsets(int[] nums) {
        double[] result = new double[1];
        Map<Integer, Set<Integer>> numMapPrimes = breakNum();

        int[] numCountArr = new int[MAX_NUMBER + 1];
        for (int num : nums) {
            if (numMapPrimes.containsKey(num)) {
                numCountArr[num]++;
            }
        }
        List<Integer> numList = new ArrayList<>();
        for (int i = 2; i < numCountArr.length; i++) {
            if (numCountArr[i] != 0) {
                numList.add(i);
            }
        }

        dfs(numList, numMapPrimes, 0, new HashSet<>(), result, numCountArr, BigInteger.ONE);
        result[0] = result[0] % MOD;
        for (int count = 1; count <= numCountArr[1]; count++) {
            result[0] = (result[0] * 2) % MOD;
        }

        return (int) result[0];
    }

    private void dfs(List<Integer> nums, Map<Integer, Set<Integer>> numMapPrimes, int index,
                     Set<Integer> addPrimes, double[] result,
                     int[] numMapCount, BigInteger mul) {
        int len = nums.size();
        if (index >= len) {
            result[0] = result[0] % MOD;
            return;
        }
        for (int i = index; i < len; i++) {
            int num = nums.get(i);
            if (hasNonUnion(numMapPrimes.get(num), addPrimes)) {
                int count = numMapCount[num];
                mul = mul.multiply(BigInteger.valueOf(count));
                result[0] += mul.mod(BigInteger.valueOf(MOD)).longValue();
                Set<Integer> primes = numMapPrimes.get(num);
                addPrimes.addAll(primes);
                dfs(nums, numMapPrimes, i + 1, addPrimes, result, numMapCount, mul);
                addPrimes.removeAll(primes);
                mul = mul.divide(BigInteger.valueOf(count));
            }
        }
    }

    private Map<Integer, Set<Integer>> breakNum() {
        Map<Integer, Set<Integer>> numMapPrimes = new HashMap<>(16);
        numMapPrimes.put(1, new HashSet<>());
        for (int num : PRIME_NUMBER) {
            Set<Integer> primes = new HashSet<>();
            primes.add(num);
            numMapPrimes.put(num, primes);
        }

        for (int i = 2; i <= MAX_NUMBER; i++) {
            if (numMapPrimes.containsKey(i)) {
                continue;
            }
            Set<Integer> primes = new HashSet<>();
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (!numMapPrimes.containsKey(j)) {
                    continue;
                }
                if (i % j == 0 && numMapPrimes.containsKey(i / j)) {
                    if (numMapPrimes.containsKey(j) && hasNonUnion(numMapPrimes.get(j), numMapPrimes.get(i / j))) {
                        primes.addAll(numMapPrimes.get(j));
                        primes.addAll(numMapPrimes.get(i / j));
                        break;
                    }
                }
            }
            if (primes.size() != 0) {
                numMapPrimes.put(i, primes);
            }
        }
        return numMapPrimes;
    }

    private boolean hasNonUnion(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() < set2.size()) {
            return set1.stream().noneMatch(set2::contains);
        }
        return set2.stream().noneMatch(set1::contains);
    }
}
