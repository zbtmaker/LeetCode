package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019\1\20 0020.
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 */
public class Subsets78 {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> sets = subsets(nums);
        for(List list : sets){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    /**
     * 这个题目我采用回溯的方式来解决，因为对于一个回溯的方案其实就是数学中的枚举方法，
     * 我们需要枚举出每一种结果。在递归的范式上需要改变的是，我们需要想到，我们从1开始
     * 我们数组中每一个元素都可以被作为树的根，然后从此处向后面采用改变值，递归，恢复现场
     * 的方式得到我们的结果。从1、2、3作为树的根开始递归，对于1而言，1后面的所有元素都可以
     * 作为一棵树的下一层平等的元素，2和3可以作为1的下一级节点的兄弟节点进行递归。然后分别对
     * 2和3进行递归，当递归到2时，此时3作为以2为根的下一级节点。我们用一个index表示我们递归到
     * 哪一个位置了，那么对于一个数组而言，当我们的index到达nums.length时,此时我们不能再递归了
     * 因此我们就返回。
     * 具体的回溯流程我们可以用树来分析，对于数组nums中每一个元素都可以当做树的根
     * 首先是1作为root
     *       1
     *      / \
     *     2  3
     *    /
     *   3
     *   大致的递归流程就是1作为根，1后面的元素2,3都是第二层的递归始节点，也就是子树的root。2作为root，后面
     *   只有3这一个元素，因此第三层只有一个分支。3作为子树的root向下面递归发现后面没有元素，自然也就返回了。
     * 然后是2作为整颗树的root
     *     2
     *    /
     *   3
     * 这个元素向后面递归只能是3，所以只有一个子节点并只有一层。
     * 从上面的分析来看，其实对于这个枚举问题就是多个-多叉树的前序遍历。
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> list = new ArrayList<List<Integer>>(1<<nums.length);
        List<Integer> array = null;
        for(int i = 0;i<nums.length;i++){
            array = new ArrayList<>();
            array.add(nums[i]);
            list.add(array);
            recurSubsets(array,i+1,nums,list);
        }
        array = new ArrayList<>();
        list.add(array);
        return list;
    }
    private static void recurSubsets(List<Integer> array,int index,
                               int[] nums,List<List<Integer>> list){
        if(index>=nums.length){
            return;
        }
        for(int j = index;j<nums.length;j++){
            array.add(nums[j]);
            list.add(new ArrayList<>(array));
            recurSubsets(array,j+1,nums,list);
            array.remove(array.size()-1);
        }
    }
}
