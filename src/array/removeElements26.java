 package array;

/**
 * Created by Administrator on 2019\1\7 0007.
 */
public class removeElements26 {
    public static void main(String[] args){
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int len = removeElement1(nums,2);
        for(int i = 0;i<len;i++){
            System.out.println(nums[i]);
        }
        System.out.println(len);
    }
    //如果需要删除后依然有序则使用当前方案
    private static int removeElement(int[] nums, int val) {
        int n = 0;
        int i= 0;
        while (i < nums.length - n) {
            if(nums[i] == val){
                for(int j = i;j<nums.length-1;j++){
                    nums[j] = nums[j+1];
                }
                n++;
            }
            if(nums[i] != val){
                i++;
            }
        }
        return nums.length-n;
    }
    //如果删除元素无需有序则使用该方法
    private static int removeElement1(int[] nums,int val){
        int n = 0;
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            if(nums[i] == val){
                swap(nums,i,j);
                j--;
                n++;
            }
            if(nums[i] != val){
                i++;
            }
        }
        if(nums[j] == val){
            n++;
        }
        return nums.length-n;
    }
    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
