package tree;

import java.util.List;

/**
 * Created by Administrator on 2019\2\22 0022.
 */
public class maxDepth559 {
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        List<Node> nodes = root.children;
        int max = 0;
        for(int i = 0;i<nodes.size();i++){
            int tmp = maxDepth(nodes.get(i));
            max = max < tmp ? tmp : max;
        }
        return max + 1;
    }
}
