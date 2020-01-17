package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrder103 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 这里我使用两个栈的方式来实现这个问题。一个栈pushStack是用来存，然后另一个栈用来存pushStack
     * 中pop出来的元素。同时我们用count来记录奇偶行，奇数行时，从pushStack中pop出来的元素然后将其
     * right,left子树放到另一个栈中，如果count为偶数，则按照当前节点的left,right放入到另一个栈中
     * 每一层执行完毕之后，count ++。依次往复执行完毕
     * @param root 二叉树的根
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> tmpList;
        Stack<TreeNode> popStack = new Stack<>();
        Stack<TreeNode> pushStack = new Stack<>();
        popStack.add(root);
        int count = 0;
        while(!popStack.isEmpty() || !pushStack.isEmpty()){
            tmpList = new LinkedList<>();
            if(!popStack.isEmpty()){
                while(!popStack.isEmpty()){
                    TreeNode node = popStack.pop();
                    tmpList.add(node.val);
                    TreeNode rightNode = node.right;
                    TreeNode leftNode = node.left;

                    if(count % 2 == 0){
                        if(node.left != null){
                            pushStack.push(leftNode);
                        }
                        if(node.right != null){
                            pushStack.push(rightNode);
                        }
                    }else{
                        if(node.right != null){
                            pushStack.push(rightNode);
                        }
                        if(node.left != null){
                            pushStack.push(rightNode);
                        }
                    }
                }

            }else{
                while(!pushStack.isEmpty()){
                    TreeNode node = pushStack.pop();
                    tmpList.add(node.val);
                    TreeNode rightNode = node.right;
                    TreeNode leftNode = node.left;

                    if(count % 2 == 0){
                        if(node.left != null){
                            popStack.push(leftNode);
                        }
                        if(node.right != null){
                            popStack.push(rightNode);
                        }
                    }else{
                        if(node.right != null){
                            popStack.push(rightNode);
                        }
                        if(node.left != null){
                            popStack.push(leftNode);
                        }
                    }
                }
            }
            count ++;
            result.add(tmpList);
        }
        return result;
    }
}
