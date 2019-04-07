package Array;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class maximumProduct628 {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4};

        System.out.println(maximumProduct(nums));
    }
    public static int maximumProduct(int[] nums){
        int max = -Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                for(int k = j+1;k<nums.length;k++){
                    int temp = nums[i]*nums[j]*nums[k];
                    if(max < temp){
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

}
