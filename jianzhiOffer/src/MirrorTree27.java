/**
 * FileName: MirrorTree27
 * author: gxs
 * Date: 2022/1/10  17:06
 */
public class MirrorTree27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null) {
            mirrorTree(root.left);
        }
        if (root.right != null) {
            mirrorTree(root.right);
        }
        return root;
    }
}
