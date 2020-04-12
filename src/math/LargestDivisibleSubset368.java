package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 * 如果有多个目标子集，返回其中任何一个均可。
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 *
 * @author baitao zou
 * date 2020/04/12
 */
public class LargestDivisibleSubset368 {

    /**
     * algorithm I:枚举法：枚举所有能够满足条件的整除子集和，然后找到最大的那个
     * algorithm II:排序+动态规划：现将整个数组进行排序，排序后根据两个推论，找到递推关系后得到最终的结果。
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        return largestDivisibleSubsetByDPII(nums);
    }

    /**
     * 看官网的两个推论
     * 给定升序序列（即 E < F < G）[E, F, G]，并且该列表本身满足问题中描述的整除子集，
     * 那么我们可以阔欧战该子集，而不必枚举该子集的所有数字，在以下两种情况：
     * 推论一：可除以整除子集中的最大元素的任何值，加入到子集中，可以形成另一个整除子集，
     * 即对于所有 h，若有 h % G == 0，则 [E, F, G, h] 形成新的可除子集。
     * 推论二：可除以整除子集中最小元素的任何值，加入到子集中，可以形成另一个整除子集，
     * 对于所有的 d，若有 E % d == 0，则 [d, E, F, G] 形成一个新的整除子集。
     * 上面两个推论可以帮助我们构造一个有效的解决方案。
     *
     * @param nums
     * @return
     */
    private List<Integer> largestDivisibleSubsetByDPI(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        int[] aux = new int[nums.length];
        aux[0] = 1;
        int max = aux[0];
        List<Integer> curSubset = new LinkedList<>();
        curSubset.add(nums[0]);

        List<List<Integer>> allSubset = new ArrayList<>(nums.length);
        allSubset.add(curSubset);
        List<Integer> maxSubSet = curSubset;
        for (int i = 1; i < nums.length; i++) {
            aux[i] = 1;
            curSubset = new LinkedList<>();
            int maxIndex = -1;
            int curMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && curMax < aux[j]) {
                    curMax = aux[j];
                    maxIndex = j;
                }
            }
            if (maxIndex != -1) {
                aux[i] = aux[maxIndex] + 1;
                curSubset.addAll(allSubset.get(maxIndex));
            }
            curSubset.add(nums[i]);
            allSubset.add(curSubset);
            if (max < aux[i]) {
                max = aux[i];
                maxSubSet = curSubset;
            }
        }
        return maxSubSet;
    }

    /**
     * 优化largestDivisibleSubsetByDPI方法，上面使用太多的空间，上面每一次找到一个最大的
     * 整除集合就会new 一个List，然后将结果放入到List当中。改进的方法就是使用一个辅助数组id用来
     * 计算每个能够使i达到最大的那个集合的一个父索引，这个思想其实是借助图算法和union find算法
     * 思想。
     *
     * @param nums
     * @return
     */
    private List<Integer> largestDivisibleSubsetByDPII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        int len = nums.length;
        int[] aux = new int[len];
        aux[0] = 1;
        int[] id = initId(len);
        int max = aux[0];
        int maxIndex = 0;
        for (int i = 1; i < len; i++) {
            aux[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && aux[i] < aux[j] + 1) {
                    aux[i] = aux[j] + 1;
                    id[i] = j;
                }
            }
            if (max < aux[i]) {
                max = aux[i];
                maxIndex = i;
            }
        }
        LinkedList<Integer> maxSubset = new LinkedList<>();
        maxSubset.addFirst(nums[maxIndex]);
        while (maxIndex != id[maxIndex]) {
            maxIndex = id[maxIndex];
            maxSubset.addFirst(nums[maxIndex]);
        }
        return maxSubset;
    }

    private int[] initId(int len) {
        int[] id = new int[len];
        for (int i = 0; i < len; i++) {
            id[i] = i;
        }
        return id;
    }

    /**
     * 采用枚举的方式能够最终还是超时了。
     *
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubsetByEnum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }
        List<Integer> maxSubset = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> subset = new LinkedList<>();
            largestDivisibleSubsetRecur(nums, i, subset, maxSubset);
        }
        return maxSubset;
    }

    /**
     * @param nums      数组
     * @param index     索引
     * @param subset    子集合
     * @param maxSubset 最大可整除子集
     */
    private void largestDivisibleSubsetRecur(int[] nums, int index, LinkedList<Integer> subset, List<Integer> maxSubset) {
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (subset.isEmpty()) {
                subset.add(nums[i]);
                if (subset.size() > maxSubset.size()) {
                    maxSubset.clear();
                    maxSubset.addAll(subset);
                }
            } else {
                if (isDivisible(subset, nums[i])) {
                    subset.addLast(nums[i]);
                    if (subset.size() > maxSubset.size()) {
                        maxSubset.clear();
                        maxSubset.addAll(subset);
                    }
                    largestDivisibleSubsetRecur(nums, i + 1, subset, maxSubset);
                    subset.removeLast();
                }
            }
        }
    }

    /**
     * 首先我们可以写出所有整除的子集的集合
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> allDivisibleSubsetByEnum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }
        List<List<Integer>> allSubset = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> subset = new LinkedList<>();
            allDivisibleSubSetRecur(nums, i, subset, allSubset);
        }
        return allSubset;
    }


    /**
     * @param nums
     * @param index
     * @param subset
     * @param allSubset
     */
    private void allDivisibleSubSetRecur(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> allSubset) {
        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (subset.isEmpty()) {
                subset.add(nums[i]);
                allSubset.add(new ArrayList<>(subset));
            } else {
                if (isDivisible(subset, nums[i])) {
                    subset.addLast(nums[i]);
                    allSubset.add(new LinkedList<>(subset));
                    allDivisibleSubSetRecur(nums, i + 1, subset, allSubset);
                    subset.removeLast();
                }
            }
        }
    }


    private boolean isDivisible(List<Integer> list, int num) {
        for (Integer element : list) {
            if (element % num != 0 && num % element != 0) {
                return false;
            }
        }
        return true;
    }

}
