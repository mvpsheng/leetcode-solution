package treesandgraphs;

/**
 * FileName: BinaryTreesIsBalanced
 * author: gxs
 * Date: 2022/1/19  19:52
 */
/* implement a function to check if a binary tree is balanced. For the purpose of this
 * question, a balanced tree is defined to be a tree such that the heights of the two
 * subtrees of any node never differ by more than one */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class BinaryTreesIsBalanced {
    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
