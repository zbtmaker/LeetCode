package Tree;

import java.util.*;

/**
 * Created by Administrator on 2019\2\25 0025.
 */
public class findFrequentTreeSum508 {
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
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(-3);
        root.left = node1;
        root.right = node2;
        /*int[] result = new findFrequentTreeSum508().findFrequentTreeSum(root);
        System.out.println(Arrays.toString(result));*/
        int[] resu = new int[]{};
        System.out.println(Arrays.toString(resu));
    }
    /**
     * 使用递归求解每一个子树的子树和，以及使用HashMap统计每一个子树和出现的次数，最后将结果输出
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {

        if(root == null){
            return new int[]{};
        }
        HashMap<Integer,Integer> map = new HashMap<>();

        recurFindFrequentTreeSum(root,0,map);

        List<Integer> list = new LinkedList<>();
        int max = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(max<entry.getValue()){
                max = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            }else if(max == entry.getValue()){
                list.add(entry.getKey());
            }

        }
        int[] result = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    private int recurFindFrequentTreeSum(TreeNode curNode,int sum,Map<Integer,Integer> map){
        if(curNode == null){
            return 0;
        }

        int leftSum = recurFindFrequentTreeSum(curNode.left,sum,map);

        int rightSum = recurFindFrequentTreeSum(curNode.right,sum,map);

        sum  =  curNode.val + leftSum + rightSum;

        if(map.containsKey(sum)){
            map.put(sum,map.get(sum)+1);
        }else{
            map.put(sum,1);
        }
        return sum;
    }
}
