/**
 * FileName: LowestCommonAncestor68
 * author: gxs
 * Date: 2022/3/11  11:58
 */
public class LowestCommonAncestor68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
