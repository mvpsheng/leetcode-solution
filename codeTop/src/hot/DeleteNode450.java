package hot;

/**
 * FileName: DeleteNode450
 * author: gxs
 * Date: 2022/2/27  14:15
 */
public class DeleteNode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
//            nochild
            if (root.right == null && root.left == null) return null;
//            only 1 child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) return root.left;
//            2 child
            TreeNode node = helper(root.right, root);
            root.val = node.val;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
    private TreeNode helper(TreeNode root, TreeNode parent) {
        TreeNode pre = parent, cur = root;
        while (cur.left != null) {
            pre = cur;
            cur = cur.left;
        }
        deleteNode(pre, cur.val);
        return cur;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode();
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.right = node7;
        node3.left = null;
        node2.left = node4;
        node2.right = node5;
    DeleteNode450 delete = new DeleteNode450();
    node6 = delete.deleteNode(node1, 3);
        System.out.println(node6.val);
    }
}
