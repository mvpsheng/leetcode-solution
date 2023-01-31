package hot;


import java.util.*;

/**
 * FileName: RightSideView199
 * author: gxs
 * Date: 2021/10/8  21:06
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
public class RightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
/**
 *        方法1：深度优先搜索
 * 用栈实现，存储一个节点的左右子树，但是保证右子数第一个出栈
 * 如果没有右子树的时候，才保存左子数，这样也保证了右视图。
 */

//        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer,Integer>();
//        int max_depth = -1;
//
//        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
//        Stack<Integer> depthStack = new Stack<Integer>();
//        nodeStack.push(root);
//        depthStack.push(0);
//        while (!nodeStack.isEmpty()) {
//            TreeNode node = nodeStack.pop();
//            int depth = depthStack.pop();
//
//            if (node != null) {
////                维护二叉树的最大深度
//                max_depth = Math.max(max_depth,depth);
//                if (!rightmostValueAtDepth.containsKey(depth)) {
//                    rightmostValueAtDepth.put(depth,node.val);
//                }
//
//                nodeStack.push(node.left);
//                nodeStack.push(node.right);
//                depthStack.push(depth + 1);
//                depthStack.push(depth + 1);
//            }
//        }
//        List<Integer> rightView = new ArrayList<Integer>();
//        for (int depth = 0; depth <= max_depth; depth++) {
//            rightView.add(rightmostValueAtDepth.get(depth));
//        }
//        return rightView;

/**
 *        方法二：广度优先遍历
 *        用队列实现，层次遍历树，将每一层节点的值都存进map
 *        最终相同的层次只会有一个值就是最右边的
 */

        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        nodeQueue.add(root);
        depthQueue.add(0);

        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if (node != null) {
//                维护二叉树的最大深度
                max_depth = Math.max(max_depth,depth);

//                由于每一层最后一个访问到的节点才是我们要的
                rightmostValueAtDepth.put(depth,node.val);

                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }
        List<Integer> rightView = new ArrayList<>();
        for (int depth = 0; depth <= max_depth ; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }
}
