package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class levelOrderBottom107 {
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


        List<List<Integer>> lists = new levelOrderBottom107().levelOrderBottom(root);
        for(List<Integer> list : lists){
            System.out.println(list);
        }

    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<>();

        if(root == null){
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();

        int levelNum = 1;
        TreeNode curNode = root;
        queue.add(curNode);

        List<Integer> tmpList = null;
        while(!queue.isEmpty()){
            int tmpLevelNum = 0;
            tmpList = new LinkedList<>();
            for(int i = 0;i<levelNum;i++){
                curNode = queue.removeFirst();
                tmpList.add(curNode.val);
                if(curNode.left != null){
                    queue.add(curNode.left);
                    tmpLevelNum ++;
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                    tmpLevelNum ++;
                }
            }
            list.addFirst(tmpList);
            levelNum = tmpLevelNum;
        }
        return list;
    }
}
