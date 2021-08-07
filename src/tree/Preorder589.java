package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class Preorder589 {

    /**
     * 这里使用递归的方式，前序的方式是：中->左->右。但是在处理子节点时和以前二叉树是不一样的，这里如果当前
     * 节点curNode的children节点是null时，需要调用recurPreorder(null,list)，如果curNode的children不为空，
     * 那么需要遍历其中的节点。
     *
     * @param root
     * @return
     */
    public List<Integer> preorderI(Node root) {
        List<Integer> list = new ArrayList<>();
        recurPreorder(root, list);
        return list;
    }

    private void recurPreorder(Node curNode, List<Integer> list) {
        if (curNode == null) {
            return;
        }

        list.add(curNode.val);

        if (curNode.children == null) {
            recurPreorder(null, list);
        } else {
            List<Node> nodes = curNode.children;
            for (Node node : nodes) {
                recurPreorder(node, list);
            }
        }
    }
}
