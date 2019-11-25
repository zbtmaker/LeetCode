package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\9 0009.
 */
public class FourSum18 {
    public static void main(String[] args){
        int[] nums = new int[]{0, 0, 0, 0, 0};
        List<List<Integer>> lists = new FourSum18().fourSum(nums,1);
        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }

    /**
     * 4-Sum请参考3-Sum，使用的总的时间为O(0.5N^3 + NlogN)这是总的运行时间，
     * 但是我们的算法时间为O(0.5N^3)，具体的思想还是需要参考一下3-sum，这里不再赘述
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0;i<nums.length - 3;i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int sum1 = target - nums[i];
                list.add(nums[i]);
                for(int j = i + 1;j < nums.length -2;j++){
                    if(j == i+1 || (j>i + 1 && nums[j] != nums[j-1] )){
                        int sum2 = sum1 - nums[j];
                        list.add(nums[j]);
                        int m = j + 1;
                        int n = nums.length-1;
                        while(m<n){
                            if(nums[m] + nums[n]>sum2){
                                n--;
                            }else if(nums[m] + nums[n] < sum2){
                                m ++;
                            }else{
                                if(m  == j+1 ||(m>j+1 && nums[m] != nums[m-1])){
                                    list.add(nums[m]);
                                    list.add(nums[n]);
                                    lists.add(new LinkedList<Integer>(list));
                                    list.removeLast();
                                    list.removeLast();
                                }
                                m++;
                                n--;
                            }
                        }
                        list.removeLast();
                    }
                }
                list.removeLast();
            }

        }
        return lists;
    }
}
