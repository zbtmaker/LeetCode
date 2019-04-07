package Array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\1\16 0016.
 */
public class findDisappearedNumbers448 {
    public static void main(String[] args){
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    /**
     * 这里使用的是一个数组来记录一下每个数出现的次数，如果次数为零的那就是缺失的数。
     * 这样就可以以空间换时间同样我们使用的List，不再使用ArrayList，因为这里使用添
     * 加元素的操作，而ArrayList的插入操作需要扩容操作，所以我们使用LinkedList来实
     * 现这样就可以节省时间。
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> list = new LinkedList<>();
        int[] index = new int[nums.length];
        for(int i =0 ;i<nums.length;i++){
            index[nums[i] - 1] += 1;
        }
        for(int i = 0;i<nums.length;i++){
            if(index[i] == 0){
                list.add(i+1);
            }
        }
        return list;
    }
}
