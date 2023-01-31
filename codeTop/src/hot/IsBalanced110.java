package hot;

/**
 * FileName: IsBalanced110
 * author: gxs
 * Date: 2021/11/16  17:34
 */
public class IsBalanced110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
//        当前树根的最有子树深度之差绝对值不大于1，而且左右数都平衡
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
//    如果当前节点已经是树根，那么深度为左右子树的较大值 + 1
    private int depth (TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }
}
