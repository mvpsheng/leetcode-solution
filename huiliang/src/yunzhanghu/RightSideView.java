package yunzhanghu;

import java.util.LinkedList;

/**
 * FileName: RightSideView
 * author: gxs
 * Date: 2021/9/19  16:20
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
     this.val = val;
   }
  }
public class RightSideView {
    public int[] RightSideView (TreeNode root) {
        // write code here
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> res = new LinkedList<Integer>();
        int[] ans = null;
        if (root == null) {
            return ans;
        }
        queue.offer(root);
        TreeNode currentRoot = null;
        while (!queue.isEmpty()) {
            currentRoot = queue.poll();
            res.add(currentRoot.val);
            if (currentRoot.right != null)
            queue.offer(currentRoot.right);
        }
        ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        RightSideView rightSideView = new RightSideView();
//        {1,2,3,#,5,#,4}
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.right.left = null;
        for (int num :
                rightSideView.RightSideView(root)) {
            System.out.print(num+" ");
        }
    }
}
