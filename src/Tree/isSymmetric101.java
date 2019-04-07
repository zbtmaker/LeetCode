package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2019\2\24 0024.
 */
public class isSymmetric101 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        node2.left = node5;
        node2.right = node6;


        System.out.println(new isSymmetric101().isSymmetric(root));
    }
    /**
     * 层次遍历大法好，
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> dequeue = new Stack<>();
        Stack<TreeNode> enqueue = new Stack<>();
        List<String> list = new ArrayList<>();

        TreeNode curNode = root;
        dequeue.push(root);

        while(!dequeue.isEmpty() || !enqueue.isEmpty()){
            if(dequeue.isEmpty()){
                while(!enqueue.isEmpty()){
                    dequeue.push(enqueue.pop());
                }
            }
            while(!dequeue.isEmpty()){
                curNode = dequeue.pop();
                if(curNode.left == null){
                    list.add("$");
                }else{
                    list.add(curNode.left.val+"");
                    enqueue.push(curNode.left);
                }
                if(curNode.right == null){
                    list.add("$");
                }else{
                    list.add(curNode.right.val + "");
                    enqueue.push(curNode.right);
                }
            }
            if(!isSymmetric(list)){
                return false;
            }
            list.clear();
        }
        return true;
    }

    public boolean isSymmetric(List<String> list){
        int i = 0;
        int j = list.size()-1;
        while(i<j){
            if(!list.get(i) .equals(list.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
