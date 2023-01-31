import java.util.Deque;
import java.util.LinkedList;

/**
 * FileName: LevelOrder32
 * author: gxs
 * Date: 2022/1/11  17:19
 */
public class LevelOrder32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode> queue = new LinkedList<>();
       LinkedList<Integer> list = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
