package hot;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * FileName: LevelOrder102
 * author: gxs
 * Date: 2021/10/9  22:09
 */
public class LevelOrder102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
           res.add(levelList);
        }
        return res;




















//        LinkedList<LinkedList<Integer>> ans = new LinkedList<>();
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        if (root == null) {
//            return ans;
//        }
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            LinkedList<Integer> res = new LinkedList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode tmp = queue.poll();
//                res.add(tmp.val);
//                if (tmp.left != null) {
//                    queue.offer(tmp.left);
//                }
//                if (tmp.right != null) {
//                    queue.offer(tmp.right);
//                }
//            }
//            ans.add(res);
//        }
//        return ans;
    }
}
