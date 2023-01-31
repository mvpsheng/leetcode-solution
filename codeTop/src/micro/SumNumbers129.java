package micro;

/**
 * FileName: SumNumbers129
 * author: gxs
 * Date: 2021/12/3  16:13
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
          this.right = right;
      }
}
public class SumNumbers129 {
    public int sumNumbers(TreeNode root) {
        return counter(root,0);
    }
    private int counter(TreeNode root, int i) {
        if (root == null) return 0;
        int tmp = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            return tmp;
        }
        return counter(root.left, tmp) + counter(root.right, tmp);
    }
}
