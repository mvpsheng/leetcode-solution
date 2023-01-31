package hot;

/**
 * FileName: MinDepth111
 * author: gxs
 * Date: 2022/3/9  23:21
 */
public class MinDepth111 {
    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + dfs(root.right);
        }

        if (root.right == null) {
            return 1 + dfs(root.left);
        }

        return 1 + Math.min(dfs(root.left), dfs(root.right));
    }
}
