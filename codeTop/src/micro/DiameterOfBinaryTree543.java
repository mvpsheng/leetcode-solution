package micro;

/**
 * FileName: DiameterOfBinaryTree543
 * author: gxs
 * Date: 2022/2/27  19:09
 */
public class DiameterOfBinaryTree543 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) return 0;
//        if (root.left == null) return levelOfTree(root.right);
//        if (root.right == null) return levelOfTree(root.left);
//        return levelOfTree(root.right) + levelOfTree(root.left);
         ans = 1;
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, right + left + 1);
        return Math.max(left, right) + 1;

    }
    private int levelOfTree(TreeNode root) {
        if (root == null) return 0;
        return Math.max(levelOfTree(root.right), levelOfTree(root.left)) + 1;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        DiameterOfBinaryTree543 diameterOfBinaryTree543 = new DiameterOfBinaryTree543();
        System.out.println(diameterOfBinaryTree543.diameterOfBinaryTree(n1));
    }
}
