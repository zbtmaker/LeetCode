package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\25 0025.
 */
public class findBottomLeftValue513 {
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
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        node3.left = node5;
        node3.right = node6;


        int val = new findBottomLeftValue513().findBottomLeftValue(root);
        System.out.println(val);

    }

    /**
     * 层次遍历大法好，借助Queue的思想实现的方案（是否用递归的方法会更好，使用递归实现的范式是什么）
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        int levelNum = 1;
        TreeNode curNode = root;
        queue.add(curNode);

        TreeNode bottoLeftNode = null;
        while(!queue.isEmpty()){
            int tmpLevelNum = 0;

            for(int i = 0;i<levelNum;i++){

                curNode = queue.removeFirst();
                if(i == 0){
                    bottoLeftNode = curNode;
                }
                if(curNode.left != null){
                    queue.add(curNode.left);
                    tmpLevelNum ++;
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                    tmpLevelNum ++;
                }
            }

            levelNum = tmpLevelNum;
        }
        return bottoLeftNode.val;
    }

}
