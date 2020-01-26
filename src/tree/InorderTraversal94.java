package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author baitao zou
 * date 2020/01/26
 */
public class InorderTraversal94 {
    public List<Integer> inorderTraversal(TreeCommonUtils.TreeNode root) {
        List<Integer> nodeList = new LinkedList<>();
        Stack<TreeCommonUtils.TreeNode> nodeStack = new Stack<>();

        TreeCommonUtils.TreeNode currentNode = root;

        while(nodeStack.size()!=0 || currentNode != null){
            if(currentNode != null){
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            }else{
                currentNode = nodeStack.pop();

                nodeList.add(currentNode.val);

                currentNode = currentNode.right;
            }
        }
        return nodeList;
    }
}
