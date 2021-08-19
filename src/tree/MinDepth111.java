package tree;

import java.util.Stack;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class MinDepth111 {
    /**
     * 这里仍然使用层次遍历去做，但是与maxDepth不同的是，对于maxDepth如果这一层的节点都是叶子节点，
     * 那么此时depth就是树的最大深度，但是minDepth是如果某一层只有有一个节点是叶子节点，那么
     * 从根节点到该叶子节点就是深度就是minDepth。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode curNode= root;

        int depth = 0;
        stack1.push(curNode);

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(stack1.isEmpty()){
                while(!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
            }
            depth ++;
            while(!stack1.isEmpty()){
                curNode = stack1.pop();
                if(curNode.left != null){
                    stack2.push(curNode.left);
                }
                if(curNode.right != null){
                    stack2.push(curNode.right);
                }
                if(curNode.right == null && curNode.left == null){
                    return depth;
                }
            }
        }
        return depth;
    }
}
