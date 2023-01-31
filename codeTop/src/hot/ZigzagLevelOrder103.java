package hot;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * FileName: ZigzagLevelOrder
 * author: gxs
 * Date: 2021/11/11  20:39
 */
public class ZigzagLevelOrder103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sequence = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            LinkedList<Integer> res = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                if (sequence % 2 == 0) {
                    res.add(cur.val);
                } else {
                    res.addFirst(cur.val);
                }
                if (cur.left != null) {
                        queue.offer(cur.left);
                }
                if (cur.right != null) {
                        queue.offer(cur.right);
                }
            }
            ans.add(res);
            sequence++;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(0);
        TreeNode r5 = new TreeNode(0);
        TreeNode r6 = new TreeNode(5);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;
        r2.left = r5;
        r2.right = r6;
        System.out.println(new ZigzagLevelOrder103().zigzagLevelOrder(root).toString());
    }
}
