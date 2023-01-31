package treesandgraphs;

/**
 * FileName: IsSubtree
 * author: gxs
 * Date: 2022/1/20  9:24
 */
/* you have two very large binary trees: T1, with millions of nodes, and T2, with hundreds
 * of nodes. Create an algorithm to decide if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n
 * is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical */

public class IsSubtree {
    boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;

        return subTree(t1, t2);
    }
    boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false;
        }
        if (r1.val == r2.val) {
            if (matchTree(r1, r2)) return true;
        }
        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }
    boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r2 == null && r1 == null) return true;

        if (r1 == null || r2 == null) return false;

        if (r1.val != r2.val) return false;

        return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
    }
}
