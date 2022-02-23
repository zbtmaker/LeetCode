package dp;

import java.util.*;

/**
 * @author zoubaitao
 * date 2022/02/22
 */
public class NumberOfGoodSubsets1994 {

    private final static int[] PRIME_NUMBER = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    private final static int MAX_NUMBER = 30;

    private final static long MOD = (long) Math.pow(10, 9) + 7;

    public int numberOfGoodSubsets(int[] nums) {
        boolean flag = Arrays.stream(nums).allMatch(num -> num == 1);
        if (flag) {
            return 0;
        }
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

        dfs(numList, numMapPrimes, 0, new HashSet<>(), result, numCountArr, 1);
        for (int count = 1; count <= numCountArr[1]; count++) {
            result[0] = (result[0] * 2) % MOD;
        }

        return (int) result[0];
    }

    private void dfs(List<Integer> nums, Map<Integer, Set<Integer>> numMapPrimes, int index,
                     Set<Integer> addPrimes, double[] result,
                     int[] numMapCount, double mul) {
        int len = nums.size();
        if (index >= len) {
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            int num = nums.get(i);
            int count = numMapCount[num];
            if ((numMapPrimes.containsKey(num) && hasUnion(numMapPrimes.get(num), addPrimes))) {
                mul *= count;
                result[0] += mul;
                Set<Integer> primes = numMapPrimes.get(num);
                addPrimes.addAll(primes);
                dfs(nums, numMapPrimes, i + 1, addPrimes, result, numMapCount, mul);
                addPrimes.removeAll(primes);
                mul /= count;
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
                    if (numMapPrimes.containsKey(j) && hasUnion(numMapPrimes.get(j), numMapPrimes.get(i / j))) {
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

    private boolean hasUnion(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() < set2.size()) {
            return set1.stream().noneMatch(set2::contains);
        }
        return set2.stream().noneMatch(set1::contains);
    }
}
