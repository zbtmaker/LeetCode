package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Administrator on 2019\2\24 0024.
 */
public class findTarget653 {
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

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;

        TreeNode node6 = new TreeNode(7);
        node2.right = node6;


        System.out.println(new findTarget653().findTarget(root,28));
    }
    /**
     * 使用前序遍历和HashMap实现，这种方式运行时间过长，是否可以运用递归的范式解决这个问题。
     * @param root 二叉树根节点
     * @param k 目标
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        TreeNode curNode = root;
        while(curNode != null || !stack.isEmpty()){
            if(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                curNode = stack.pop();
                if(map.containsKey(curNode.val)){
                    return true;
                }else{
                    map.put(k - curNode.val,curNode.val);
                }
                curNode = curNode.right;
            }
        }
        return false;
    }

    /**
     * 使用前序实现
     * @return
     */
    public boolean preorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        TreeNode curNode = root;
        while(curNode != null || !stack.isEmpty()){
            if(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                curNode = stack.pop();
                System.out.println(curNode.val);
                curNode = curNode.left;
            }
        }
        return false;
    }
}
