package array;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class checkPossibility665 {
    public static void main(String[] args){
        int[] nums = new int[]{4};
        System.out.println(checkPossibility(nums));
    }
    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                count ++;
            }
        }
        return count > 1 ? false : true;
    }
}
