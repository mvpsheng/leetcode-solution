/**
 * FileName: KthLargest54
 * author: gxs
 * Date: 2022/1/13  9:29
 */
public class KthLargest54 {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 1)
            res = root.val;
        else --k;
        dfs(root.left);
    }
}
