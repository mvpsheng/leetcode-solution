/**
 * FileName: MaxDepth55
 * author: gxs
 * Date: 2022/1/13  9:39
 */
public class MaxDepth55 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1: right + 1;
    }
}
