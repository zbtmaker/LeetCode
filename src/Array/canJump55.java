package Array;

/**
 * Created by Administrator on 2019\2\28 0028.
 */
public class canJump55 {
    public static void main(String[] args){
        int[] nums = new int[]{3,2,1,0,4};
        canJump55 canJump = new canJump55();
        System.out.println(canJump.canJumpII(nums));

    }
    /**
     * 从后往前判断，是不是后面有这样的路径，前面一定存在呢。因此我的思路就是第一次找到一个元素
     * 这个元素是能够到最后一个节点的元素，那么我们就将这个
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        return recurJump(nums,nums.length-1);

    }
    public boolean recurJump(int[] nums,int index){
        if(index <= 0){
            return true;
        }
        for(int j = index -1;j>-1;j--){
            if(index - j <= nums[j] && recurJump(nums,j)){
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
     * @param nums
     * @return
     */
    public boolean canJumpII(int[] nums){
        return recurCanJumpII(nums,nums.length-1);
    }

    private boolean recurCanJumpII(int[] nums,int last){
        if(last == 0){
            return true;
        }
        for(int i = last-1;i>-1;i--){
            if(nums[i] >= (last - i)){
                last = i;
                return recurCanJumpII(nums,last);
            }
        }
        return false;
    }

}
