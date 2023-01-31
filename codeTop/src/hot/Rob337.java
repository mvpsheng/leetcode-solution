package hot;

/**
 * FileName: Rob337
 * author: gxs
 * Date: 2021/11/27  17:46
 */
public class Rob337 {
    public int rob(TreeNode root) {
       int[] res = robInternal(root);
       return Math.max(res[0],res[1]);
    }
    public int[] robInternal(TreeNode root) {
        if (root== null) {
            return new int[2];
        }
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0],left[1]) +
                Math.max(right[0] , right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;

    }
}
