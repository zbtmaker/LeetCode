package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class postorder590 {
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        recurPostorder(root,list);
        return list;
    }

    private void recurPostorder(Node curNode,List<Integer> list){
        if(curNode == null){
            return;
        }

        if(curNode.children == null){
            recurPostorder(null,list);
        }else{
            List<Node> nodes = curNode.children;
            for(Node node : nodes){
                recurPostorder(node,list);
            }
        }
        list.add(curNode.val);
    }
}
