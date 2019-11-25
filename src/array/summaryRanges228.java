package array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\28 0028.
 */
public class summaryRanges228 {
    public static void main(String[] args){
        summaryRanges228 summary = new summaryRanges228();
        System.out.println(summary.summaryRanges(new int[]{0,1,2,4,5,7}));
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();
        int start = nums[0];
        String s = null;
        int i = 1;
        while(i<nums.length){
            if(nums[i] - nums[i - 1] == 1){
                start = nums[i-1];
                i++;
                while(i<nums.length && nums[i] - nums[i-1] ==1){
                    i++;
                }
                if(start == nums[i-1]){
                     s = start+"";
                }else{
                     s = start+"->"+ nums[i-1];
                }
                list.add(s);
                start = nums[i];
            }else{
                if(nums[i] == start){
                    s = start+"";
                }else{
                    s = start + "->" + nums[i];
                }
                list.add(s);

            }
            i++;
        }
        return list;
    }
}
