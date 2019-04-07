package Array;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class missingNumber268 {
    public int missingNumber(int[] nums) {
        int[] index = new int[nums.length + 1];
        for(int i = 0;i<nums.length;i++){
            index[nums[i]] ++;
        }
        for(int j = 0;j<index.length;j++){
            if(index[j] == 0){
                return j;
            }
        }
        return -1;
    }
}
