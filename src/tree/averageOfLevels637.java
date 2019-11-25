package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class averageOfLevels637 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> lists = new ArrayList<>();
        if(root == null){
            return lists;
        }
        Stack<TreeNode> dequeue = new Stack();
        Stack<TreeNode> enqueue = new Stack();

        TreeNode curNode = root;

        dequeue.push(curNode);

        while(!dequeue.isEmpty() || !enqueue.isEmpty()){
            if(dequeue.isEmpty()){
                while(!enqueue.isEmpty()){
                    dequeue.push(enqueue.pop());
                }
            }

            List<Integer> list = new ArrayList<>();
            double sum = 0;
            int count = 0;
            while(!dequeue.isEmpty()){
                curNode = dequeue.pop();
                count ++;
                sum += curNode.val;
                if(curNode.left != null){
                    enqueue.push(curNode.left);
                }
                if(curNode.right != null){
                    enqueue.push(curNode.right);
                }

            }

            lists.add(sum/count);
            sum = 0;
            count = 0;
        }
        return lists;
    }
}
