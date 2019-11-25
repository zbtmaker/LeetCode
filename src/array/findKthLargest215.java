package array;

import org.junit.Test;

public class findKthLargest215 {
    @Test
    public void test1(){
        findKthLargest215 find = new findKthLargest215();
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = find.findKthLargest(nums,4);
        System.out.println(k);
    }
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while(true){
            index = partition(nums,left,right);
            if(index > nums.length - k){
                right = index - 1;
            }else if(index < nums.length - k){
                left = index + 1;

            }else{
                return nums[index];
            }
        }

    }

    private int  partition(int[] nums,int left,int right){
        int pivot = nums[left];
        int i = left - 1;
        int j = right;
        for(int k = left;k <= right;k++){
            if(nums[k] <= pivot){
                swap(nums,i + 1,k);
                i ++;
            }

        }
        swap(nums,left,i);
        return i;
    }
    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
