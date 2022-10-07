package dp;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zoubaitao
 * date 2022/10/07
 */
public class Rob337 {

    /**
     * 这里对于每个root, 小偷可以偷或者偷root节点，如果这个节点偷了，那么root.left和root.right就不能再偷了。
     * 如果没有偷root节点，那么root.left和root.right节点是可以偷的。相同的因为每一个节点都可以看作是一个root节点
     * 因此，相当于每次递归都有一个相同的范式。
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        return dfsMemorize(root);
    }

    private int dfs(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        return flag ?
                Math.max(root.val + dfs(root.left, false) + dfs(root.right, false),
                        dfs(root.left, true) + dfs(root.right, true))
                : dfs(root.left, true) + dfs(root.right, true);

    }

    private int dfsMemorize(TreeNode root) {
        Map<Boolean, Map<TreeNode, Integer>> memo = new HashMap<>();
        memo.put(Boolean.TRUE, new HashMap<>());
        memo.put(Boolean.FALSE, new HashMap<>());
        dfsMemorize(root, true, memo);
        return memo.get(Boolean.TRUE).get(root);
    }

    private int dfsMemorize(TreeNode root, boolean flag, Map<Boolean, Map<TreeNode, Integer>> memo) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, Integer> flagMap = memo.get(flag);
        Integer res = flagMap.get(root);
        if (res != null) {
            return res;
        }
        res = flag ?
                Math.max(root.val + dfsMemorize(root.left, false, memo) + dfsMemorize(root.right, false, memo),
                        dfsMemorize(root.left, true, memo) + dfsMemorize(root.right, true, memo))
                : dfsMemorize(root.left, true, memo) + dfsMemorize(root.right, true, memo);
        flagMap.put(root, res);
        return res;
    }
}
