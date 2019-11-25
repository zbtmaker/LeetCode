package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\3 0003.
 */
public class subsetsWithDup90 {
    public static void main(String[] args){
        int[] nums = new int[]{4,4,4,1,4};
        List<List<Integer>> lists = new subsetsWithDup90().subsetsWithDup(nums);
        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }
    /**
     * 本题是subsets78的变异体。递归大法：
     * 测试例子A : nums=[1,2,2] 通过
     * 测试例子B : nums=[4,4,4,1,4]通过
     * 测试例子C : nums=[]通过
     * 顺便吐槽一下这个题这里有个特别坑的地方就是我还需要输出空集
     *
     * 此题目的具体思想和subsets78的问题是一样的，但是这个问题有一个问题就是nums中
     * 存在重复的元素，如果再按照之前的方法，那么我们就会在最终的集合中出现重复的集合。
     * 对于那么出现重复问题，去重有两种方式：排序和HashMap去重。对于HashMap去重的方式
     * 可以是在每一个位置用一个HashMap来去重，或者是在最终结果进行去重，这里比较麻烦。
     * 我们采用另一种方式达到结果去重的方式，首先我们将数组中的元素进行排序，然后再同一层
     * 不能出现同样的元素，这样就可以实现去重的目的。
     * 同样我们用subsets78的思路以每一个元素作为根来进行递归，例子就是nums=[4,4,4,1,4]，第一步经过排序后
     * nums=[1,4,4,4,4]
     *                    1
     *         /      \      \      \
     *        4        4      4       4
     *       / \ \    / \      \
     *      4  4  4  4   4      4
     *     / \  \    \
     *    4  4  4     4
     *   /
     *  4
     * 从上面的结果我们可以发现，一旦出现重复的数字，那么在树的同一层当中，如果继续出现该数字，那么此结果
     * 就会导致集合重复的情况，因此如果在同一层由重复的元素，那么我们直接跳过，而不对该元素进行递归，相当于剪枝了。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        lists.add(new LinkedList<>());
        if(nums == null || nums.length == 0){
            return lists;
        }
        Arrays.sort(nums);
        LinkedList list = new LinkedList();

        recurSubsetWithDup(nums,0,list,lists);
        return lists;
    }

    private void recurSubsetWithDup(int[] nums,int index,LinkedList<Integer> list,
                                    List<List<Integer>> lists){
        if(index == nums.length){
            return;
        }
        for(int i = index;i<nums.length;i++){
            if(i == index || ((i> index) && nums[i] != nums[i-1])){
                list.add(nums[i]);
                lists.add(new LinkedList<>(list));
                recurSubsetWithDup(nums,i+1,list,lists);
                list.removeLast();
            }
        }
    }
}
