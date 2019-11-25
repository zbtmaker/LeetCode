package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\25 0025.
 */
public class pathSum437 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public int pathSum(TreeNode root, int target) {
        List<Integer> list = new LinkedList<Integer>();
        //recurPathSum(curNode,target,sum,list);
        return 0;
    }

    /**
     *
     * @param curNode
     * @param target
     * @param sum
     * @param list
     */
    private int recurPathSum(TreeNode curNode, int target, int sum, List<Integer> list){
        if(curNode.left == null && curNode.right == null){

            return sum;
        }else{
            if(curNode.left != null){
                list.add(curNode.left.val);
                sum = recurPathSum(curNode.left,target,sum,list);
                list.remove(list.size() -1);
            }
            if(curNode.right != null){
                list.add(curNode.right.val);
                sum = recurPathSum(curNode.right,target,sum,list);
                list.remove(list.size() -1);
            }
        }
        return sum;
    }
}
