package tree;

import java.util.Stack;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class MaxDepth104 {

    /**
     * 此方法是采用自顶向下的动态规划问题，当前节点的最大值等于其left节点的最大值+1，和right节点的最大值
     * +1的比较，数学表达式可以写成maxDepth(curNode) = max{maxDepth(curNode.left)+1,maxDepth(curNode.left)+1}
     * 结束条件就是如果当前curNode == null，那么一次节点为根节点的最大深度为0。
     * 运行时间 1ms ,运行内存：27.5MB
     *
     * @param root
     * @return
     */
    public int maxDepthI(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepthI(root.left), maxDepthI(root.right)) + 1;
    }

    /**
     * 我们用层次遍历的方法也可以得到一棵树的最大深度，但是需要队列Queue工具来实现，当然我们也可以用两个堆栈来实现一个队列
     * 一个用于存储当前栈，另一个用于存储下一层的节点。
     * 这里需要注意的是，我们用于衡量数深度的变量depth一开始为0，我们用stack1来存储当前层的节点，stack2用来存储
     * 下一层的节点，因此因此我们的stack1每出栈一次，我们的depth++。最后返回depth
     * 运行时间 7ms，内存为 24.2MB
     *
     * @param root
     * @return
     */
    public int maxDepthII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode curNode = root;

        int depth = 0;
        stack1.push(curNode);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
            while (!stack1.isEmpty()) {
                curNode = stack1.pop();
                if (curNode.left != null) {
                    stack2.push(curNode.left);
                }
                if (curNode.right != null) {
                    stack2.push(curNode.right);
                }

            }
            depth++;
        }
        return depth;
    }
}
