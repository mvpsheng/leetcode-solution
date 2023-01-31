package hot;

/**
 * FileName: MaxPathSum124
 * author: gxs
 * Date: 2022/3/9  18:58
 */
public class MaxPathSum124 {
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        ans = Math.max(ans, node.val + left + right);
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(-7);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(new MaxPathSum124().maxPathSum(n1));
    }
}
