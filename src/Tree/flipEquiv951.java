package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\25 0025.
 */
public class flipEquiv951 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();

        int levelNum1 = 1;
        TreeNode curNode1 = root1;
        queue1.add(curNode1);

        TreeNode curNode2 = root2;
        queue2.add(curNode2);

        List<Integer> tmpList = null;
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            int tmpLevelNum1 = 0;
            for(int i = 0;i<levelNum1;i++){
                curNode1 = queue1.removeFirst();

                if(curNode1.left == null){
                    list1.add("$");
                }
                if(curNode1.left != null){
                    queue1.add(curNode1.left);
                    list1.add(curNode1.left.val+"");
                    tmpLevelNum1 ++;
                }
                if(curNode1.right == null){
                    list1.add("$");
                }
                if(curNode1.right != null){
                    queue1.add(curNode1.right);
                    list1.add(curNode1.right.val+"");
                    tmpLevelNum1 ++;
                }

                curNode2 = queue2.removeFirst();

                if(curNode2.left == null){
                    list2.add("$");
                }
                if(curNode2.left != null){
                    queue2.add(curNode2.left);
                    list2.add(curNode2.left.val+"");
                }
                if(curNode2.right == null){
                    list2.add("$");
                }
                if(curNode2.right != null){
                    queue2.add(curNode2.right);
                    list2.add(curNode2.right.val+"");
                }
            }
            if(!isSymmetic(list1,list2)){
                return false;
            }
            levelNum1 = tmpLevelNum1;
        }
        return true;
    }

    private boolean isSymmetic(List<String> list1,List<String> list2){
        if(list1.size() != list2.size()){
            return false;
        }
        int i = 0;
        int j = list1.size()-1;
        while(i<=list1.size()-1 && j>=0){
            if(list1.get(i) != list2.get(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
