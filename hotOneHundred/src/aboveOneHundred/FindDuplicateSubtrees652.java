package aboveOneHundred;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * FileName: FindDuplicateSubtrees652
 * author: gxs
 * Date: 2023/1/30  18:20
 * counter: 1
 */
public class FindDuplicateSubtrees652 {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return result;
    }

//    前序或者后序遍历将子树转化为字符串，value保存这个字符串出现的次数
    private String dfs(TreeNode node) {
        if (node == null) return"";
        String key = new StringBuilder().append(node.val).append(",")
                .append(dfs(node.left)).append(",").append(dfs(node.right)).toString();
        if (map.getOrDefault(key, 0) == 1) {
            result.add(node);
        }
        map.put(key, map.getOrDefault(key, 0) + 1);
        return key;
    }
}
