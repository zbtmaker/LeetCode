package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\3 0003.
 */
public class permute46 {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4};
        new permute46().permute(nums);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if(nums == null || nums.length == 0){
            return lists;
        }

        recurPermute(nums,0,lists);
        return lists;
    }

    /**
     * 递归大法好，在递归操作中，每一个节点的通式包括两部分：
     * （I）向后面的元素直接进行递归
     * （II）与后面的元素进行交换之后，然后进行递归
     *
     * 具体的流程：但是我们的递归的范式是什么呢，也就是对于其中的某一位的广泛操作（其实相当于高中学的通项式）
     * 每一个节点都需要进行递归如果：[1,2,3]，我们用一个指针index表示递归哪个索引了，首先我们的index指向0，
     * 然后index+1=2，然后递归到2节点，然后递归的3节点，此时index=nums.length，此时这一个递归就结束了。
     * 我们直接return就可以了。然后是2和3进行交换，交换之后，那么就应该index+1指向下一个也就是2
     * 此时2可以和后面的元素都交换完了，那么这个时候就应该返回了。回到1之后，1和其后面的元素一一交换，同样
     * 进行递归。
     *
     * @param nums
     * @param index
     * @param lists
     */
    private void recurPermute(int[] nums,int index,List<List<Integer>> lists){
        if(index == nums.length-1){
            lists.add(add(nums));
            System.out.println(Arrays.toString(nums));
            return;
        }
        recurPermute(nums,index+1,lists);//
        for(int i = index+1;i<nums.length;i++){
            swap(nums,index,i);
            recurPermute(nums,index+1,lists);
            swap(nums,index,i);
        }
    }

    /**
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private List<Integer> add(int[] nums){
        List<Integer> list = new LinkedList<>();
        for(int i = 0;i<nums.length;i++){
            list.add(nums[i]);
        }
        return list;
    }
}
