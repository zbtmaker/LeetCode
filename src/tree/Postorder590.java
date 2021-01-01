package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class Postorder590 {
    /**
     * 多叉树后序遍历
     *
     * @param root 多叉树根节点
     * @return 后续遍历数组
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        recurPostorder(root, list);
        return list;
    }

    private void recurPostorder(Node curNode, List<Integer> list) {
        if (curNode == null) {
            return;
        }

        if (curNode.children == null) {
            recurPostorder(null, list);
        } else {
            List<Node> nodes = curNode.children;
            for (Node node : nodes) {
                recurPostorder(node, list);
            }
        }
        list.add(curNode.val);
    }
}
