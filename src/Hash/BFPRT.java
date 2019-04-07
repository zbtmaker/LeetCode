package Hash;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\31 0031.
 * Step I：  将数组进行分组，每五个数进行分组成一组。
 * Step II:  将刚才分好组的每个子数组进行排序，排好序以后将
 * Step III: 取每个排好序的子数组的中数组来构成一个新的数组，然后重复I、II，
 *           直到数组中的元素少于5，然后取其中位数用于作为partition的值。
 */
public class BFPRT {
    public static void main(String[] args){
        int[] nums = new int[]{3,2,1,4,6,0,1,2,3,5,2,3,4};
        //int partition = new BFPRT().bfprt(nums);
    }
    public int bfprt(int[] nums){
        int[] temp = new int[5];

        for(int i = 0,j=0;i<nums.length;i++){
            temp[j] = nums[i];
            if(j+1 % 5 == 0){
                Arrays.sort(temp);
            }

        }
        return 0;
    }
}
