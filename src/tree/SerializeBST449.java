package tree;

/**
 * Created by Administrator on 2019\3\22 0022.
 */
public class SerializeBST449 {
    /**
     * 这里我们使用前序遍历的方式实现二叉搜索树的序列化，那么我们只需要调用
     * preOrder的递归版本实现就可以了。
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root,sb);
        return sb.toString();

    }

    /**
     * 这里我们将使用前序遍历的递归版本实现我们的序列化，就是如果我们的当前节点
     * 非空，那么我们将使用node.val + "!"添加到StringBuilder当中，为什么是这样了
     * 这是为了我们在后面反序列化的时候，直接使用String.split("!")将数字直接
     * 分隔开，有助于使用内部算法来实现我们的字符串分割。
     * @param root
     * @param sb
     */
    private void preorder(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("$!");
            return ;
        }
        sb.append(root.val + "!");
        preorder(root.left,sb);
        preorder(root.right,sb);
    }
    /**
     * 这个俗话说的好，请神容易送神难，那么我又如何实现将一个前序遍历的二叉树
     * 字符串转换成一个二叉树呢，这是一个问题？在网上有使用插入的方式来实现
     * 二叉树的反序列化。中心思想还是preorder的递归版本来实现这个方案，
     * 其实非递归版本也是可以实现的，但是可能需要多个指针来实现。
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        String[] strs = data.split("!");
        int[] index = new int[]{0};
        return recurDeseriable(strs,index);
    }
    public TreeNode recurDeseriable(String[] strs,int[] index){
        if(strs == null || index[0] == strs.length){
            return null;
        }
        TreeNode root = null;
        String s = strs[index[0]];
        if(!s.equals("$")){
            root = new TreeNode(Integer.parseInt(s));
            index[0] = index[0] + 1;
            root.left = recurDeseriable(strs,index);
            root.right = recurDeseriable(strs,index);
        }else{
            index[0] = index[0] + 1;
        }
        return root;
    }
}
