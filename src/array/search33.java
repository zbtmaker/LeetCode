package array;

/**
 * Created by Administrator on 2019\1\11 0011.
 */
public class search33 {
    public static void main(String[] args){

    }
    public int search(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        //int mid = (left + right)>>1;
        if(nums[left]>target){
            left = (left+right)>>1;
        }
        return -1;

    }
}
