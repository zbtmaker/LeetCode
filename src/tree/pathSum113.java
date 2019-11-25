package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\23 0023.
 */
public class pathSum113 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(11);
        node1.left = node3;
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node3.left = node4;
        node3.right = node5;

        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        node2.left = node6;
        node2.right = node7;

        TreeNode node8 = new TreeNode(5);
        node7.right = node8;

        List<List<Integer>> lists = new pathSum113().pathSum(root,22);

        for(List<Integer> list :lists){
            System.out.println(lists);
        }

    }

    /**
     * 这就是一个回溯法能够解决的题，其中的难点就在于递归的范式中的halting rule，对于一个从根节点到叶子节点
     * 总和，那么只有当当前节点curNode.left==null且curNode.right == null 且径路之和sum == target的时候
     * 此时我们将list当中的元素添加到lists当中。我们在决定了halting rule之后，那么我们需要对每一个节点的下
     * 一步递归进行判断。因为停止halting rule是curNode.left 和 curNode.right都要等于零，那么这个时候我们
     * 在对curNode的left和right进行递归的时候，就需要首先判断curNode的left和right是否为null，如果不为null
     * 那么就进行下一步递归调用。
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return lists;
        }

        list.add(root.val);
        recurPathSum(root,target,root.val,lists,list);
        return lists;
    }

    private void recurPathSum(TreeNode curNode,int target,int sum,
                              List<List<Integer>> lists,List<Integer> list){
        if(curNode.left == null && curNode.right == null
                && sum == target){
            lists.add(new ArrayList<>(list));
            return;
        }else{
            if(curNode.left != null){
                sum += curNode.left.val;
                list.add(curNode.left.val);
                recurPathSum(curNode.left,target,sum,lists,list);
                sum -= curNode.left.val;
                list.remove(list.size() -1);
            }

            if(curNode.right != null){
                sum += curNode.right.val;
                list.add(curNode.right.val);
                recurPathSum(curNode.right,target,sum,lists,list);
                sum -= curNode.right.val;
                list.remove(list.size() -1);
            }
        }
    }
}
