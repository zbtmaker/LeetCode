package tree;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树公共工具类
 *
 * @author baitao zou
 * date 2020/01/18
 */
public class TreeCommonUtils {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 后序遍历：堆栈方式
     *
     * @param root 二叉树根节点
     * @return 二叉树所有节点值
     */
    public List<Integer> postOrderTraversalOutList(TreeNode root) {
        TreeNode node = root;
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode lastNodeVisited = null;
        while (stack.size() != 0 || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && lastNodeVisited != peekNode.right) {
                    node = peekNode.right;
                } else {
                    list.add(peekNode.val);
                    lastNodeVisited = stack.pop();
                }
            }
        }
        return list;
    }

    /**
     * 后序遍历：堆栈方式
     *
     * @param root 根节点
     */
    public void postOrderTraverseByStack(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode lastNodeVisited = null;
        while (stack.size() != 0 || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && lastNodeVisited != peekNode.right) {
                    node = peekNode.right;
                } else {
                    lastNodeVisited = stack.pop();
                }
            }
        }
    }

    /**
     * 后序遍历：递归方式
     *
     * @param root 二叉树根节点
     */
    public void postOrderTraverseByRecursiveOutList(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return;
        }
        postOrderTraverseByRecursive(root.left);
        postOrderTraverseByRecursive(root.right);
        valList.add(root.val);
    }

    /**
     * 后序遍历：递归方式
     *
     * @param root 二叉树根节点
     */
    public void postOrderTraverseByRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraverseByRecursive(root.left);
        postOrderTraverseByRecursive(root.right);
        System.out.println(root.val);
    }

    /**
     * 中序遍历：堆栈方式，并返回List
     *
     * @param root 二叉树根节点
     * @return 二叉树所有节点的值
     */
    public List<Integer> inOrderTraverseByStackOutList(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> valList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            if (node.left != null) {
                stack.push(node.left);
                node = node.left;
            } else {
                node = stack.pop();
                valList.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                    node = node.right;
                }
            }
        }

        return valList;
    }

    /**
     * 中序遍历-堆栈方式，将节点值存在集合中
     *
     * @param root    子树的根节点
     * @param valList 存储节点值的集合
     */
    public void inOrderTraverseByRecursiveOutList(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return;
        }
        inOrderTraverseByRecursiveOutList(root.left, valList);
        valList.add(root.val);
        inOrderTraverseByRecursiveOutList(root.right, valList);
    }

    /**
     * 中序遍历：递归方式
     *
     * @param root 根节点
     */
    public void inOrderTraverseByRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraverseByRecursive(root.left);
        System.out.println(root.val);
        inOrderTraverseByRecursive(root.right);
    }

    /**
     * 先序遍历：堆栈方式
     *
     * @param root 二叉树的根
     */
    public void preOrderTraverseByStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 前序遍历：堆栈方式，并返回所有节点的值集合
     *
     * @param root 根节点
     * @return 所有节点的值集合
     */
    public List<Integer> preOrderTraverseByStackOutList(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> rootList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            rootList.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return rootList;
    }


    /**
     * 先序遍历：递归方式
     *
     * @param root 二叉树的根
     */
    public void preOrderTraverseByRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTraverseByRecursive(root.left);
        preOrderTraverseByRecursive(root.right);
    }

    /**
     * 前序遍历：递归方式，并将结果保存在列表当中
     *
     * @param root    子树的根节点
     * @param valList 保存节点值的List
     */
    public void preOrderTraverseByRecursiveList(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return;
        }
        valList.add(root.val);
        preOrderTraverseByRecursive(root.left);
        preOrderTraverseByRecursive(root.right);
    }
}
