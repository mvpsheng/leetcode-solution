package hot;

import java.util.LinkedList;

/**
 * FileName: BSTIterator173
 * author: gxs
 * Date: 2021/11/27  9:37
 */
public class BSTIterator173 {
    LinkedList<TreeNode> stack;
    TreeNode root;
    public BSTIterator173(TreeNode root) {
        stack = new LinkedList<TreeNode>();
        this.root = root;
    }

    public int next() {
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                int res = root.val;
                root = root.right;
                return res;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return 0;
    }

    public boolean hasNext() {
        return root != null || !stack.isEmpty();
    }
}
