package array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\3\4 0004.
 */
public class rotate189 {
    public static void main(String[] args){
        int[] nums = new int[]{-1,-100,3,99};
        new rotate189().rotate(nums,2);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 其实对于数组头尾循环的方式，经常采用的方式就是将数组长度变为当前的2倍，同时利用mod运算来解决
     * 这里我们没有使用2倍数组的方式，但是我们需要将最后一位nums.length - 1 和
     * (nums.length % nums.length = 0) 进行向前移。循环边界是1 -> nums.length
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        for(int i = 0;i<k;i++){
            int last = nums[0];
            for(int j = 1;j<=nums.length;j++){
                int temp = nums[j%nums.length];
                nums[j%nums.length] = last;
                last = temp;
            }
        }
    }

    /**
     * 这里我们找到循环旋转的规律，这里和链表循环旋转是一样的
     * @param nums
     * @param k
     */
    public void rotateII(int[] nums, int k){

    }
}
