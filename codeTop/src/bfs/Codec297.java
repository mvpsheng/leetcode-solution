package bfs;


import java.util.LinkedList;
import java.util.List;

/**
 * FileName: Codec
 * author: gxs
 * Date: 2022/3/25  15:37
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
public class Codec297 {
    private static final String NULL = "#";
    private static final String SEP = ",";

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL + SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        List<String> vals = new LinkedList<>();
        for (String x : data.split(SEP)) {
            vals.add(x);
        }
        return deserialize(vals);
    }

    public TreeNode deserialize(List<String> vals) {
        String first = vals.remove(0);
        if (NULL.equals(first)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(vals);
        root.right = deserialize(vals);
        return root;
    }
}
