/**
 * FileName: IsSubStructure26
 * author: gxs
 * Date: 2022/1/9  16:32
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class IsSubStructure26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (tree1HasTree2(A, B) ||
          isSubStructure(A.left, B) ||
           isSubStructure(A.right, B));
    }
    boolean tree1HasTree2(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return tree1HasTree2(A.left, B.left) && tree1HasTree2(A.right, B.right);
    }
}
