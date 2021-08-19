package hash;

/**
 * Created by Administrator on 2019\2\1 0001.
 */
public class FindErrorNums645 {

    public int[] findErrorNums(int[] nums) {
        int[] right = new int[nums.length];
        int[] info = new int[2];
        for(int i = 0;i<nums.length;i++){
            if(right[nums[i] - 1] == 1){
                info[0] = nums[i];
            }else{
                right[nums[i] - 1] = 1;
            }
        }
        for(int j = 0;j<nums.length;j++){
            if(right[j] == 0){
                info[1] = j + 1;
            }
        }

        return  info;
    }
}
