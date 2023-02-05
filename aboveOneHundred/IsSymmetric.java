package aboveOneHundred;

import java.util.LinkedList;

/**
 * FileName: IsSymmetric
 * author: gxs
 * Date: 2022/12/7  11:21
 * name: 判断是否对称二叉树
 */
public class IsSymmetric {
//    方法1： dfs， 递归方式， 判断左节点的右子 和 右节点的左子 对称判断是否相同
//    方法2： 用队列将遍历的结果保存下来，每一层判断是否相同
    public boolean isSymmetric(TreeNode root) {
//        if(root == null) {
//            return true;
//        }
//        //调用递归函数，比较左节点，右节点
//        return dfs(root.left,root.right);

//        方法2：
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();

            if (left == null && right == null) {
                continue;
            }

            if(left == null || right == null) {
                return false;
            }
            if(left.val != right.val) {
                return false;
            }
//            对称的将子节点加入到队列中
            queue.add(left.right);
            queue.add(right.left);

            queue.add(left.left);
            queue.add(right.right);
        }
        return true;
    }

//    private boolean dfs(TreeNode left, TreeNode right) {
//        if(left == null && right == null) {
//            return true;
//        }
//        if(left == null || right == null) {
//            return false;
//        }
//        if(left.val != right.val) {
//            return false;
//        }
//        return dfs(left.right, right.left) && dfs(left.left, right.right);
//    }
}
