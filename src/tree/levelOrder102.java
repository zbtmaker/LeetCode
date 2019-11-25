package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class levelOrder102 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * 层次遍历就是使用一个队列来实现，但是在Java中没有线程不安全的Queue，所以我使用了两个Stack来实现
     * 我们的队列，一个Stack为enqueue用来入栈队列中的元素，另一个Stack为inqueue用来出栈元素。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
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

            while(!dequeue.isEmpty()){
                curNode = dequeue.pop();
                list.add(curNode.val);
                if(curNode.left != null){
                    enqueue.push(curNode.left);
                }
                if(curNode.right != null){
                    enqueue.push(curNode.right);
                }

            }

            lists.add(list);
        }
        return lists;
    }
}
