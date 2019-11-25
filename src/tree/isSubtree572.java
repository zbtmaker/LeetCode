package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\22 0022.
 */
public class isSubtree572 {
    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //first step:将树进行序列化
        List<String> arrays = serialize(s);
        List<String> arrayt = serialize(t);

        int lens = arrays.size();
        int lent = arrayt.size();
        //second step:构造一个next数组
        int[] next = getNext(arrayt);
        //Third step:使用KMP思想进行比较
        int i = 0;
        int j = 0;
        while(i < lens && j < lent){
            if(j != lent && arrays.get(i).equals(arrayt.get(j))){
                i ++;
                j ++;
            }else if(j == 0){
                i ++;
            }
            else{
                j = next[j -1];
            }
        }
        return j == lent ? true : false;
    }

    private int[] getNext(List<String> array){
        int[] next = new int[array.size()];
        next[0] = 0;
        int i = 1;
        while(i < array.size()){
            String s = array.get(i);
            if(s .equals(array.get(next[i - 1]))){
                next[i] = next[i - 1] + 1;
            }else{
                int j = next[i - 1];
                while(j > 0 && !s.equals(array.get(next[j]))){
                    j = next[j -1];
                }
                if(j == 0){
                    if(!s.equals(array.get(next[j]))){
                        next[i] = 0;
                    }else{
                        next[i] = next[j] + 1;
                    }
                }else{
                    next[i] = next[j] + 1;
                }

            }
            i++;
        }
        return next;
    }
    /**
     * 序列化一棵树
     * @param root
     * @return
     */
    private List<String> serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        preorder(root,list);
        return list;

    }
    private void preorder(TreeNode root,List<String> list){
        if(root == null){
            list.add("$");
            return ;
        }
        list.add(root.val + "");
        preorder(root.left,list);
        preorder(root.right,list);
    }
}
