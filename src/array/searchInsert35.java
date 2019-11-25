package array;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class searchInsert35 {
    public static void main(String[] args){
        int[] nums = new int[]{1,3,5,7};
        System.out.println(searchInsert(nums,8));
    }
    public static int searchInsert(int[] nums,int target){
        int index = -1;
        int left = 0;
        int right = nums.length-1;
        int middle = (left + right)>>1;
        while(left<=right){
            if(nums[middle]>target){
                right = middle - 1;
                if(left>right){
                    index = middle;
                }
            }else if(nums[middle]<target){
                left = middle + 1;
                if(left>right){
                    index = middle + 1;
                }
            }else{
                index = middle;
                break;
            }
            middle = (left + right)>>1;
        }
        return index;
    }
}
