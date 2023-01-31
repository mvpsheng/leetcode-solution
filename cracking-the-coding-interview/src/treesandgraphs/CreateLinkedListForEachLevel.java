package treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * FileName: CreateLinkedListForEachLevel
 * author: gxs
 * Date: 2022/1/19  20:28
 */
public class CreateLinkedListForEachLevel {
    ArrayList<LinkedList<TreeNode>> createLinkedList(TreeNode root) {
      ArrayList<LinkedList<TreeNode>> res = new ArrayList<>();
        /* "visit" the root */
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        while (current.size() > 0) {
            res.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for (TreeNode parent:
                 parents) {
                /* visit the children */
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return res;
    }
}
