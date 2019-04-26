package Array;

import org.junit.Test;

public class findKthLargest215 {
    @Test
    public void test1(){
        findKthLargest215 find = new findKthLargest215();
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = find.findKthLargest(nums,3);
    }
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length;
        int index = - 1;
        while(true){
            index = partition(nums,left,right);
            if(index > k){
                right = index - 1;
            }else if(index < k){
                left = index + 1;

            }else{
                return nums[k];
            }
        }

    }

    private int  partition(int[] nums,int right,int left){
        int pivot = nums[right];
        int i = right - 1;
        int j = right;
        for(int k = right;j<nums.length;j++){
            if(nums[k]>=pivot){
                swap(nums,i + 1,k);
                i ++;
            }
        }
        swap(nums,right,i);
        return i;
    }
    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
