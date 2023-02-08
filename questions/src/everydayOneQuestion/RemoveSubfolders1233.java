package everydayOneQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: RemoveSubfolders1233
 * author: gxs
 * Date: 2023/2/8  9:35
 */
public class RemoveSubfolders1233 {
    /**
     *  0. 题号
     *      1233. 删除子文件夹
     *  1. 约束分析
     *      数组长度为[1, 4 * 10000]
     *      文件名长度为[2, 100]，只包含小写字母和‘/’
     *      总是以‘/’开头
     *      每个文件夹名是唯一的
     *  2. 思路
     *      前缀树，将所有文件夹名称加入前缀树中，通过dfs找出所有根节点
     *      树节点有索引值， 有子树的map，
     *      最短的文件夹的孩子节点为空， 之后扫描的孩子节点会成为最短的文件夹节点的子节点，这些子节点的索引值 ！= -1，
     *      在dfs过程中，只会将节点索引为-1的节点加入结果集合，那么结果集合中的就是非子文件夹。
     *  3. 数据结构与算法选择、复杂度分析
     *      时间： ，所以是O(N)
     *      空间： ，所以是O(1)
     *  4. 核心代码
     *
     *  5. 测试
     * */
    class Trie {
        int ref;
        Map<String, Trie> children;

        public Trie() {
            this.ref = -1;
            children = new HashMap<>();
        }
    }
    public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();
        for (int i = 0; i < folder.length; i++) {
            List<String> path = split(folder[i]);
            Trie cur = root;
            for (String name : path) {
                cur.children.putIfAbsent(name, new Trie());
                cur = cur.children.get(name);
            }
            cur.ref = i;
        }

        List<String> ans = new ArrayList<>();
        dfs(folder, ans, root);
        return ans;

    }

    private void dfs(String[] folder, List<String> ans, Trie cur) {
        if (cur.ref != -1) {
            ans.add(folder[cur.ref]);
            return;
        }
        for (Trie child: cur.children.values()) {
            dfs(folder, ans, child);
        }
    }

    public List<String> split(String s) {
        List<String> ret = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '/') {
                ret.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.append(ch);
            }
        }
        ret.add(cur.toString());
        return ret;
    }

    public static void main(String[] args) {
        String[] folder = {"/a","/a/b/c","/a/b/d"};
//        for (String s :
//                folder) {
//            System.out.println(new RemoveSubfolders1233().split(s));
//        }
        System.out.println(new RemoveSubfolders1233().removeSubfolders(folder));
    }
}
