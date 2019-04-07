package BackTracking;

/**
 * Created by Administrator on 2019\3\3 0003.
 */
public class getPermutation60 {
    public static void main(String[] args){
        String s = new getPermutation60().getPermutation(4,9);
        System.out.println(s);
    }
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = i+1;
        }
        StringBuilder sb = new StringBuilder();
        recurPermuteII(nums,0,new int[]{k},sb);
        return sb.toString();
    }

    /**
     * permute46实现的是非字典排序，所以我们在permute46的基础上改进了一下实现了字典排序，因此
     * 解释说明：[1,2,3,4]，当递归到1,2,3,4时，这个时候要是想保证字典序列，此时的index=2，而 i=4，
     * 首先执行一下swap(index,i)得到的结果为1,4,3,2,如果这个时候直接执行recurPermuteII，那么结果和permute46
     * 一样，我们想要结果有序，那么我们就需要使index+1到i（包括index+1和i）有序，这样我们的结果就是有序的
     * 那么由1432，在3和2之间做交换得到1423，然后继续递归。在这一层递归结束以后，我们得到的结果是1423，那么此时
     * 我们就需要从前面往后面（index+1,i）进行swap得到1432,然后执行一下swap(index,i)将实现递归的恢复。
     * @param nums
     * @param index
     * @param round
     * @param sb
     */
    private void recurPermuteII(int[]nums,int index,int[] round,StringBuilder sb){
        if(index == nums.length-1){
            round[0] -= 1;
            if(round[0] == 0){
                for(int i = 0;i<nums.length;i++){
                    sb.append(nums[i]);
                }
            }
            return;
        }

        recurPermuteII(nums,index + 1,round,sb);
        for(int i = index+1;i<nums.length;i++){
            swap(nums,index,i);
            //这里需要一个操作
            for(int j = i;j>index+1;j--){
                swap(nums,j,j-1);
            }

            recurPermuteII(nums,index+1,round,sb);
            //这里对应一个回复操作
            for(int l = index + 1;l<i;l++){
                swap(nums,l,l+1);
            }
            swap(nums,index,i);
        }
        return;
    }

    /**
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /***

     */
}
