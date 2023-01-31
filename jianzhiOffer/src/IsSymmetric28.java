/**
 * FileName: IsSymmetric28
 * author: gxs
 * Date: 2022/1/10  17:15
 */
public class IsSymmetric28 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }
    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetric(root1.left, root2.right) &&
                isSymmetric(root1.right, root2.left);
    }
}
