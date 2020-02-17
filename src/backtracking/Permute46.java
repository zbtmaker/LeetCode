package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 46.给定一个没有重复数字的序列，返回其所有可能的全排列。
 * Created by Administrator on 2019\3\3 0003.
 */
public class Permute46 {

    /**
     * 既然是需要穷举, 那么就是所有的例子, 这个时候首先想到的肯定是使用回溯算法。
     * 如果要使用回溯, 那么实现主要是两个步骤(a. 递归)和(b.保护现场).
     * a. 对于递归, 我们主要是需要找到递归范式, 递归范式可以从穷举过程中总结出来
     * b. 对于保护现场主要是使用递归之前进行了什么操作, 递归之后就需要再进行一次同样操作来还原现场.
     * <p>
     * testcase nums=[1, 2, 3, 4]
     * [1, 2, 3, 4] -> [1, 2, 4, 3] -> [1, 3, 2, 4] -> [1, 3, 4, 2] -> [1, 4, 2, 3] -> [1, 4, 3, 2]
     * [2, 1, 3, 4] -> [2, 1, 4, 3] -> [2, 3, 1, 4] -> [2, 3, 4, 1] -> [2, 4, 1, 3] -> [2, 4, 3, 1]
     * [3, 1, 2, 4] -> [3, 1, 4, 2] -> [3, 2, 1, 4] -> [3, 2, 4, 1] -> [3, 4, 1, 2] -> [3, 4, 2, 1]
     * [4, 1, 2, 3] -> [4, 1, 3, 2] -> [4, 2, 1, 3] -> [4, 2, 3, 1] -> [4, 3, 1, 1] -> [4, 3, 2, 1]
     * 分析:
     * 我们看从[1, 2, 3, 4] -> [4, 1, 2, 3]经历了那几个步骤
     * a. swap[nums, 0, 3], 数组变为[4, 2, 3, 1], 与目标数组不符合，交换之后的后面的一个数需要移到该数组之前所在位置的后一个位置
     * b. for(int i = k; i < index + 1; i--) {
     *        swap(nums, i, i-1);
     *    }
     * 经历上一个操作之后就得到我们想要的一个数组了[4, 1, 2, 3]
     * 从上面两个步骤我们可以知道对于每一个起始位置都会有这样一个操作，那么中间就是递归操作了，然后恢复现场就可以了。
     * 这里又一个需要注意的地方有两点
     * a. 我们的List使用ArrayList还是LinkedList, 这里我选用LinkedList, 因为只有添加操作，不涉及任何索引的操作
     * b. 递归的时候索引该如何变化，这个时候应该做的是既然是递归，那么就可以画一个栈
     * c. 最后需要注意的是，递归之前进行了什么操作，递归之后也要进行相应的操作，否则会引起问题
     *
     * @param nums 数组
     * @return 结果集合
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }

        recurPermute(nums, 0, lists);
        return lists;
    }

    /**
     * 递归范式
     *
     * @param nums  数组
     * @param index 开始递归的索引
     * @param lists 结果
     */
    private void recurPermute(int[] nums, int index, List<List<Integer>> lists) {
        if (index == nums.length) {
            lists.add(add(nums));
            /*System.out.println(Arrays.toString(nums));*/
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            for (int j = i; j > index + 1; j--) {
                swap(nums, j, j - 1);
            }
            recurPermute(nums, index + 1, lists);
            for (int k = index + 1; k < i; k++) {
                swap(nums, k, k + 1);
            }
            swap(nums, index, i);
        }
    }

    /**
     * 交换两个数组
     *
     * @param nums 数组
     * @param i    第一个索引
     * @param j    第二个索引
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 将数组添加到List当中
     *
     * @param nums 数组
     * @return List
     */
    private List<Integer> add(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }
}
