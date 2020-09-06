package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个题目第一版做的时候采用的是枚举的方式，通过枚举的方式实现，时间复杂度为O(k),如果递归不算空间的话，那么
 * 空间复杂度为O（1）。如果我们k较大的情况下，此时耗时会非常长。因此我们通过找规律的方式实现。对于一个给定长度
 * 为n，那么对于{1,...,n}，此时有1开头的字符串有(n-1)!种，同样对于2...n的字符开头也都有(n-1)!种，那么我们可以
 * 根据k / (n-1)!就能确定我们第一个数的取值
 * I：这里需要注意的是如果k % (n-1)! = 0 ,那么表示以 (k / (n-1)) - 1开头的字符串，后面的字符串是剩余字符串的
 * 一个倒序输出，例如n = 3,此时k = 4,那么此时表示以2开头的字符串的最后一个其实就是剩余字符串{1,3}的一个倒序是"213"。
 * II：如果k % (n-1) != 1,此时表示以(k / (n-1))开头的字符串，但是剩余的字符串应该怎么排序呢？其实就是把这个问题优化成
 * 一个更小的问题了，这个问题就变成了{1,...j-1, j-1, ...n}从这n-1中找到第(k % (n-1))排列了。
 * 从上面的I、II来看这个问题就是一个大问题就一通过一步化成一个更小的问题，而小问题的要解决的问题和当初要解决的大问题是一样
 * 的，因此递归方法就成了一个很好的问题。
 *
 * @author Baitao zou
 * date 2019\3\3
 */
public class GetPermutation60 {

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        recurPermuteII(nums, 0, new int[]{k}, sb);
        return sb.toString();
    }

    /**
     * 123
     * 132
     * 213
     * 231
     * 312
     * 321
     * n = n - 1; 此时
     * total = 6;
     * k = 5
     * 5 / 2 = 2
     * 5 % 2 = 1
     * <p>
     * 这个题目一开始
     *
     * @param n 数
     * @param k 第K个大小的数据
     * @return 返回字符串
     */
    public String getPermutationII(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int total = 1;
        for (int i = 2; i < n; i++) {
            total *= i;
        }
        StringBuilder sb = new StringBuilder();
        //第i位
        recur(n, k, total, list, sb);
        return sb.toString();
    }

    private void recur(int n, int k, int total, List<Integer> list, StringBuilder sb) {

        //第i位
        int div = k / total;
        int res = k % total;
        if (res == 0) {
            sb.append(list.remove(div - 1));
            for (int i = list.size() - 1; i >= 0; i--) {
                sb.append(list.get(i));
            }
            return;
        } else {
            sb.append(list.remove(div));
        }

        recur(n - 1, res, total / (n - 1), list, sb);
    }

    /**
     * permute46实现的是非字典排序，所以我们在permute46的基础上改进了一下实现了字典排序，因此
     * 解释说明：[1,2,3,4]，当递归到1,2,3,4时，这个时候要是想保证字典序列，此时的index=2，而 i=4，
     * 首先执行一下swap(index,i)得到的结果为1,4,3,2,如果这个时候直接执行recurPermuteII，那么结果和permute46
     * 一样，我们想要结果有序，那么我们就需要使index+1到i（包括index+1和i）有序，这样我们的结果就是有序的
     * 那么由1432，在3和2之间做交换得到1423，然后继续递归。在这一层递归结束以后，我们得到的结果是1423，那么此时
     * 我们就需要从前面往后面（index+1,i）进行swap得到1432,然后执行一下swap(index,i)将实现递归的恢复。
     *
     * @param nums
     * @param index
     * @param round
     * @param sb
     */
    private void recurPermuteII(int[] nums, int index, int[] round, StringBuilder sb) {
        if (index == nums.length - 1) {
            round[0] -= 1;
            if (round[0] == 0) {
                for (int i = 0; i < nums.length; i++) {
                    sb.append(nums[i]);
                }
            }
            return;
        }

        recurPermuteII(nums, index + 1, round, sb);
        for (int i = index + 1; i < nums.length; i++) {
            swap(nums, index, i);
            //这里需要一个操作
            for (int j = i; j > index + 1; j--) {
                swap(nums, j, j - 1);
            }

            recurPermuteII(nums, index + 1, round, sb);
            //这里对应一个回复操作
            for (int l = index + 1; l < i; l++) {
                swap(nums, l, l + 1);
            }
            swap(nums, index, i);
        }
    }

    /**
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
