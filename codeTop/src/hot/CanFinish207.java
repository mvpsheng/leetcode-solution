package hot;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: CanFinish207
 * author: gxs
 * Date: 2021/11/15  16:58
 */
public class CanFinish207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
//        邻接矩阵构建
        for (int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
//        对每个节点判断是否有环
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
//        再本轮已经被访问，说明有环
        if (flags[i] == 1) return false;
//        被其他节点访问，跳过
        if (flags[i] == -1) return true;
        flags[i] = 1;
//        递归访问当前节点的邻接结点
        for (Integer j : adjacency.get(i)) {
            if (!dfs(adjacency, flags, j)) return false;
        }
//        当前节点所有邻接结点都被遍历，没有环，则flag置为-1
        flags[i] = -1;
        return true;
    }

    public static void main(String[] args) {
        int[][] test = {{1,0},{0,1}};
        System.out.println(new CanFinish207().canFinish(2, test));
    }
}
