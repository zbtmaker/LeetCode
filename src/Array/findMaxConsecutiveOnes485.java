package Array;

/**
 * Created by Administrator on 2019\1\16 0016.
 */
public class findMaxConsecutiveOnes485 {
    public static void main(String[] args){
        int[] nums = new int[]{0,1,0,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    public static int findMaxConsecutiveOnes(int[] nums){
        int max = 0;
        int i = 0;
        int j = 0;
        while(i<nums.length){
            while(i<nums.length && nums[i] == 1){
                i++;
                j++;
                if(max<j){
                    max = j;
                }
            }
            j = 0;
            i++;
        }
        return max;

    }

}
