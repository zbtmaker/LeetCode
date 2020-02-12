package array;

import java.util.Map;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class MajorityElement169 {
    /**
     * 题目分析：本题的要求是找出数组中重复次数超过(n/2向下取整).如果n = 3,那么重复次数必须是2，如果n=4,那么重复次数必须是3
     * <p>
     * 1、排序法：time complexity O(NlogN), space complexity O(1)
     * 2、HashMap统计法，time complexity O(N), space complexity O(N)
     * 3、Boyer-Moore 投票算法：time complexity O(N) ,space complexity O(1)
     *
     * @param nums 目标素组
     * @return 出现次数最多的元素
     */
    public int majorityElement(int[] nums) {
        /*return majorityElementByHashMap(nums);*/
        return majorityElementByBoyerMoore(nums);
    }

    /**
     * 求众数，可以用HashMap统计词频，然后扫描一遍之后求得最大值，
     * 这种情况下的time complexity 为O(N), space complexity为O(N).
     *
     * @param nums
     * @return
     */
    private int majorityElementByHashMap(int[] nums) {
        Map<Integer, Integer> map = ArrayUtils.count(nums);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (nums.length >> 1)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 这里参考Leetcode的官方题解，使用BoyerMoore找出整个数组超出半数的元素。
     * 相当于投票，如果有人投了这个元素一票，那么我们就用majcount++,来表示后面有人赞成这个元素，
     * 否则就用minCount--,表示有人不赞成。如果投反对票和投赞成票的数量一致，那么我们前面的元素就可以不管了。
     * 因为我们要找的这个元素肯定是比一半要多的。我们这个时候就推举下一个元素为众数，重复上面的步骤。
     * 原理就是：首先选择第一个元素作为众数，如果发现后面的元素与这个
     * 元素相同，那么我们就将投这个众数的增加一票。否则，
     *
     * @param nums
     * @return
     */
    private int majorityElementByBoyerMoore(int[] nums) {
        int majority = nums[0];
        int majCount = 1;
        int minCount = 0;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == majority) {
                majCount++;
            } else {
                minCount--;
            }
            if (majCount == -minCount) {
                i++;
                majCount = 1;
                minCount = 0;
                majority = nums[i];
            }
            i++;
        }
        return majority;
    }
}
