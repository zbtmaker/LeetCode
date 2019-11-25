package array;

import java.util.*;

/**
 * Created by Administrator on 2019\2\27 0027.
 */
public class ThreeSum15 {
    public static void main(String[] args){
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new ThreeSum15().threeSumII(nums);
        for(List<Integer> list :lists){
            System.out.println(list);
        }
    }

    /**
     * 前面想到了用一个外循环+两数之和来做，但是再用HashMap的时候没法去重，所以我想到了去重的两种方法
     * （一种是在某个位置上进行记录，具体可以参考全排列II；另一种方法就是将元素进行排序，得到排好序的数组
     * 然后判断是否和前一个元素相同，如果相同，则跳过此元素，如果不同则从此元素开始）。对于3-sum，我们知道
     * 外层循环的重复好去，但是使用HashMap的内存循环很麻烦，因此我采用了将数组进行排序之后使用双指针的方法
     * 实现，具体的思想就是如果首尾两个元素之和nums[j]+nums[k]>target,那么我们就将右边的指针左移（k--因为
     * 右边的元素泰塔）；如果首尾两个元素之和nums[j]+nums[k]<target，那么我们将左边的指针右移（j++因为左边
     * 的元素太小），一旦发现首尾两个元素之和nums[j]+nums[k]==target，我们便将其添加到List当中，与此同时我
     * 们的两个指针同时向中间靠拢(j++,k--),循环结束的条件就是j < k，以上就是整个题的思路。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumII(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0;i<nums.length - 2;i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int sum = 0 - nums[i];
                list.add(nums[i]);
                int j = i + 1;
                int k = nums.length-1;
                while(j<k){
                    if(nums[j] + nums[k]>sum){
                        k--;
                    }else if(nums[j] + nums[k] < sum){
                        j ++;
                    }else{
                        if(j  == i+1 ||(j>i+1 && nums[j] != nums[j-1])){
                            list.add(nums[j]);
                            list.add(nums[k]);
                            lists.add(new LinkedList<Integer>(list));
                            list.removeLast();
                            list.removeLast();
                        }
                        j++;
                        k--;
                    }
                }
                list.removeLast();
            }

        }
        return lists;
    }

    /**
     */
}
