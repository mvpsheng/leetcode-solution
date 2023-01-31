package aboveOneHundred;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * FileName: KthSmallest230
 * author: gxs
 * Date: 2021/9/26  19:08
 */

public class KthSmallest230 {
    public int kthSmallest(TreeNode root, int k) {
//        解法一：递归构造平衡二叉树，中序遍历，这样数组自然有序
//    ArrayList<Integer> nums = inorder(root,new ArrayList<Integer>());
//    return nums.get(k - 1);
//        解法二：迭代 堆栈
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
    public ArrayList<Integer> inorder(TreeNode root,ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return arr;
    }
}
