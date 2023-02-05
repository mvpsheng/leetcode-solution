package aboveOneHundred;


import java.util.LinkedList;
import java.util.List;

/**
 * FileName: LevelOrder
 * author: gxs
 * Date: 2021/9/21  12:15
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
public class LevelOrder {
//    层次遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> ans = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                ans.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            res.add(ans);
        }
        return res;
    }
}
