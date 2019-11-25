package array;

/**
 * Created by Administrator on 2019\3\8 0008.
 */
public class MaximumProductSubarray152 {
    public static void main(String[] args){
        int[] nums = new int[]{-2,0,-1};
        int max = new MaximumProductSubarray152().maxProduct(nums);
        System.out.print(max);
    }
    /**
     * 最大连续子序列乘积和最大连续子序列和的想法是一样的，但是需要注意的是需要
     * 需要使用两个数，一个数用来记录连续和，不管这个数是大于零还是小于零：mul1
     * 另一个数用来记录大于零的乘积：mul2。如果mul1 = 0,那么我们会将mul1 = 1,
     * 如果mul2 <= 0,那么我们会将mul = 1。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int mul1 = 1;
        int mul2 = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            mul1 *= nums[i];
            mul2 *= nums[i];
            if(max<mul1){
                max = mul1;
            }
            if(max < mul2){
                max = mul2;
            }
            if(mul1 == 0){
                mul1 = 1;
            }
            if(mul2 <=0){
                mul2 = 1;
            }
        }
        return max;
    }
}
