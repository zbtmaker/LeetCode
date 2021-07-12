package dp;

/**
 * @author Baitao Zou
 * date 2019/2/28
 */
public class CanJump55 {
    /**
     * 从后往前判断，是不是后面有这样的路径，前面一定存在呢。因此我的思路就是第一次找到一个元素
     * 这个元素是能够到最后一个节点的元素，那么我们就将这个
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        return canJumpIV(nums);
    }

    public boolean recurJump(int[] nums, int index) {
        if (index <= 0) {
            return true;
        }
        for (int j = index - 1; j > -1; j--) {
            if (index - j <= nums[j] && recurJump(nums, j)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 之前我采用回溯的方式来实现这个方案，发现对于nums长度较长的情况下会出现
     * 时间超过的情况。因此我想到了DP和Greedy的方式，对于DP的方式是一定存在
     * 能够达到的情况才能做，那么只剩下Greedy方法了。对于Greedy的方式和DP的自顶
     * 向下分析，我们从最后一个节点出发，找到第一个能够到达最后节点的节点。这里为什么是
     * 最近的，而不是最远的呢？这是因为如果存在一个远的节点能够到达最后一个节点，那么
     * 这个远的节点自然也能达到这个近的节点，所以我们选择一个近的节点就可以了。一旦选择
     * 这个近的节点，那么我们将这个近的节点作为最终节点，然后依次的递归上面的操作，如果last节点
     * 最终没有达到0节点，那么返回false，如果last节点能够到达0位置，那么表示可以达到
     * 最终的节点，返回true。也就是最终的问题的解决依赖子问题的解决，这里我们定义的子问题
     * 只有一个。和动态规划的思想是一样的（其实Greedy是DP的一种）
     *
     * @param nums
     * @return
     */
    public boolean canJumpII(int[] nums) {
        return recurCanJumpII(nums, nums.length - 1);
    }

    private boolean recurCanJumpII(int[] nums, int last) {
        if (last == 0) {
            return true;
        }
        for (int i = last - 1; i > -1; i--) {
            if (nums[i] >= (last - i)) {
                last = i;
                return recurCanJumpII(nums, last);
            }
        }
        return false;
    }

    /**
     * 这种动态规划的题目，如果说怎么去解决，其实就是我们可以先写出一个从数组尾部递归到头部的
     * 递归代码，然后画出一个递归树就能看出其中的猫腻，就是会出现反复计算的问题，那么反复计算会
     * 自然而然会想到使用Memorization的方式存储结果。
     * 今天我要换一种思路，不需要从递归然后得到重复计算后才能想到使用动态规划的思考方式：我们要从头部跳到
     * 数组的尾部，那么我们是不是需要在最尾部往前找到一个索引的位置，我们假设这个位置为k，终点位置用t表示，
     * 如果我们从t位置能够向前找到一个位置k使得t - k <= nums[k]，那么说明存在一个节点能够跳到当前数组的
     * 尾部。那么为什么只要找到第一个节点就可以了，而不需要考虑k前面的节点呢？这是因为加入我们存在一个位置
     * j，其中j满足j < k < t，同时满足t - j < nums[j]。那么就有k - j < t - j < nums[j],
     * 这个公式用人话或者说是更通俗一点就是说明存在一个位置k，这个位置能够跳到数组的尾部，且这个位置不是离数
     * 组尾部最近的哪个点，那么我们就只需要找到一个能跳到尾部t最近的一个点l就可以了，而且t的结果和l的结果是
     * 相同的。
     * 根据上面的分析，其实我们将一个大的问题分解成求一个小的问题，既然一个大的问题能分解成一个较小的问题，同时
     * 我们在求这个小问题的同时，发现我们可以通过求一个更小的问题来解决这个小问题的时候，最终把问题依次分解，当问题
     * 不能再分的时候，就得到最小问题minimize problem的解。最小问题的解得到之后，我们就能够求解分解成小问题的
     * 那个问题的解。相当于我们在分解问题时是从大到小，最终在解问题时又是从小到大。因此我们就可以在具体实现的时候，
     * 首先解决小问题，然后将小问题的解存储起来；小问题的解就能够作为其中的一个因子求解大问题，这种方式就是动态规划
     * 中的Memorization。前面的分析方式就是找到求解问题的范式（范式就是统一的方式），根据这种范式我们就能写出递归
     * 表达式，然后根据递归表达式自顶向下求解，最终也还是要回归到Memorization的方式，只不过一个是自顶向下求解，而
     * 另一个自底向上求解
     *
     *
     * @param nums
     * @return
     */
    private boolean canJumpIII(int[] nums) {
        int len = nums.length;
        boolean[] flag = new boolean[len];
        flag[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j <= nums[j]) {
                    flag[i] = flag[j];
                    break;
                }
            }
            if (!flag[i]) {
                return false;
            }
        }
        return flag[len - 1];
    }

    /**
     * 这种方式是上面动态规划的优化，但是在LeetCode上运行时间一样，而且上面的运行空间更小
     * 现在就是，上面用一个数组保持了前面能够满足的条件，而下面就是用一个临时变量解决的问题。
     * @param nums
     * @return
     */
    private boolean canJumpIV(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k < i) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

}
