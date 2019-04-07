package Array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\10 0010.
 */
public class nextPermutation31 {
    public static void main(String[] args){
        int[] nums = new int[]{2, 3, 1};
        new nextPermutation31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 测试案例I ： 1234 全部通过
     * 测试例子 A : 1234 -> 1243
     * 测试例子 C : 3241 -> 3412
     * 测试例子 B : 2341 -> 2413
     *
     * 测试案例 II : 1115 此例子也全部通过
     *
     * 从上面的测试例子中就可以看出，当我们在第i个位置比i-1位置的值大时，这个时候我们就应该
     * 从第i个位置往后开始找，找到那个大于nums[i-1]的集合中最小的值，然后进行交换，交换以后
     * 将nums从第i个位置到nums.length进行一个升序排列，这样就得到了nextPermutation。
     * （2341 -> 2413，从这个例子就可以看出，此时4比3大，但是后面也没有比1大的值，所以将
     * 4和3进行交换以后得到2431，然后将31进行排序，就得到了2413。
     * @param nums
     */
    public void nextPermutation(int[] nums){
        if(nums == null ||nums.length <=1){
            return;
        }
        int len = nums.length;

        for(int i = len -1;i>0;i--){
            if(nums[i] > nums[i-1]){
                int index = -1;
                int error = Integer.MAX_VALUE;
                for(int k = i;k<len;k++){
                    if(nums[k] > nums[i-1] && (nums[k] - nums[i-1])<error){
                        error = nums[k] - nums[i-1];
                        index = k;
                    }
                }
                swap(nums,i-1,index);
                Arrays.sort(nums,i,len);
                return;
            }
        }
        int i = 0;
        int j = len-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /**
     * 测试案例I ： 1234
     * 1234     1243    1324    1342    1423    1432
     *
     * 2134     2143    2314    2341    2413    2431
     *
     * 3124     3142    3214    3241    3412    3421
     *
     * 4123     4132    4213    4231    4312    4321
     */
}
