package aboveOneHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: BuildTree
 * author: gxs
 * Date: 2021/9/21  17:09
 */
public class BuildTree {
//    给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
//    Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
//        构造哈希映射，帮助我们快速定位根节点
      indexMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n - 1,0,n -1);
    }
    public TreeNode myBuildTree(int[] preorder,int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
//        前序遍历中第一个节点是根节点
        int preorder_root = preorder_left;
//        中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
//        先把根节点建立起来
        TreeNode root = new TreeNode(preorder[preorder_root]);
//        得到左子数中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
//        递归地构造左子树，并连接到根节点
//        先序遍历中{从左边界+1 开始的size_left_subtree}个
        root.left = myBuildTree(preorder,inorder,preorder_left + 1,preorder_left + size_left_subtree,inorder_left,inorder_root - 1);
        root.right = myBuildTree(preorder,inorder,preorder_left + size_left_subtree + 1,preorder_right,inorder_root + 1,inorder_right);
        return root;
    }
}
