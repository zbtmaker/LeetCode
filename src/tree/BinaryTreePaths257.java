package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Baitao zou
 * date 2019/2/23
 */
public class BinaryTreePaths257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return result;
        }
        list.add(root.val);
        recurBinaryTreePaths(root, list, result);
        return result;
    }

    private void recurBinaryTreePaths(TreeNode curNode, LinkedList<Integer> list, List<String> result) {
        if (curNode.left == null && curNode.right == null) {
            result.add(listToStr(list));
            return;
        }

        if (curNode.left != null) {
            list.add(curNode.left.val);
            recurBinaryTreePaths(curNode.left, list, result);
            list.removeLast();
        }
        if (curNode.right != null) {
            list.add(curNode.right.val);
            recurBinaryTreePaths(curNode.right, list, result);
            list.removeLast();
        }
    }

    private String listToStr(List<Integer> values) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Integer value : values) {
            sb.append(value);
            if (i != values.size()) {
                sb.append("->");
            }
            i++;
        }
        return sb.toString();
    }
}
