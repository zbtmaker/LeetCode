package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2019\2\24 0024.
 */
public class largestValues515 {
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

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(9);
        //node2.left = node5;
        node2.right = node6;


        System.out.println(new largestValues515().largestValuesII(root));
    }

    /**
     * 使用堆栈实现的队列，需要两个Stack来实现一个队列
     * @param root
     * @return
     */
    public List<Integer> largestValuesI(TreeNode root) {
        List<Integer> maxList = new ArrayList<>();
        if(root == null){
            return maxList;
        }

        Stack<TreeNode> dequeue = new Stack<>();
        Stack<TreeNode> enqueue = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode curNode = root;
        dequeue.push(curNode);
        maxList.add(curNode.val);
        while(!dequeue.isEmpty() || !enqueue.isEmpty()){
            if(dequeue.isEmpty()){
                while(!enqueue.isEmpty()){
                    dequeue.push(enqueue.pop());
                }
            }
            while(!dequeue.isEmpty()){
                curNode = dequeue.pop();
                if(curNode.left != null){
                    list.add(curNode.left.val);
                    enqueue.push(curNode.left);
                }
                if(curNode.right != null){
                    list.add(curNode.right.val);
                    enqueue.push(curNode.right);
                }
            }
            if(list.size()>0){
                maxList.add(maxOfList(list));
            }

            list.clear();
        }
        return maxList;
    }

    /**
     * 使用链表实现的队列方案，并借助一个levelNum记录一下每一层的节点数量
     * @param root
     * @return
     */
    public List<Integer> largestValuesII(TreeNode root) {
        List<Integer> maxList = new ArrayList<>();
        if(root == null){
            return maxList;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        TreeNode curNode = root;

        queue.add(curNode);
        int levelNum = 1;

        while(!queue.isEmpty()){
            int tmpLevelNum = 0;

            for(int i = 0;i<levelNum;i++){
                curNode = queue.removeFirst();
                list.add(curNode.val);
                if(curNode.left != null){
                    queue.add(curNode.left);
                    tmpLevelNum ++;
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                    tmpLevelNum ++;
                }
            }
            maxList.add(maxOfList(list));
            list.clear();
            levelNum = tmpLevelNum;
        }
        return maxList;
    }

    /**
     * 求一个数组中的最大元素值
     * @param list
     * @return
     */
    private int maxOfList(List<Integer> list){
        int max = Integer.MIN_VALUE;
        for(Integer i : list){
            if(max < i){
                max = i;
            }
        }
        return max;
    }
}
