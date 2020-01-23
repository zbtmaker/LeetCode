package array;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class CheckPossibility665 {

    /**
     * 这个题目的重点是要记住前一个最大值，然后比较一下前一个最大值和当前的值，
     * a.如果相等，则不更新最大值
     * b.如果钱买呢的最大值大于小于当前值，那么更新最大值为当前值；
     * c.如果前面的最大值大于当前值，那么count++表示需要更改的数量
     * @param nums
     * @return
     */
    public  boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                count ++;
            }
        }
        return count > 1 ? false : true;
    }
}
