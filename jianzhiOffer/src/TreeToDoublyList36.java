/**
 * FileName: TreeToDoublyList36
 * author: gxs
 * Date: 2022/1/12  11:12
 */
class DNode {
    public int val;
    public DNode left;
    public DNode right;

    public DNode() {}

    public DNode(int _val) {
        val = _val;
    }

    public DNode(int _val,DNode _left,DNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class TreeToDoublyList36 {
    DNode pre = null, head = null;
    public DNode treeToDoublyList(DNode root) {
        if (root == null) return root;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(DNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null) pre.right = root;
        else head = root;
        root.left = pre;
        pre = root;
        dfs(root.right);
    }

}
