package stacks;



/**
 * FileName: BinaryTreeIsBalanaced
 * author: gxs
 * Date: 2022/1/19  14:54
 */
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
/* implement a function to check if a binary tree is balanced. For the purpose of this
 * question, a balanced tree is defined to be a tree such that the heights of the two
 * subtrees of any node never differ by more than one */
public class BinaryTreeIsBalanaced {
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);
    }
}
