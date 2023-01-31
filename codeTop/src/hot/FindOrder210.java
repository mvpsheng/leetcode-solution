package hot;

import java.util.*;

/**
 * FileName: FindOrder210
 * author: gxs
 * Date: 2022/2/28  13:03
 */
public class FindOrder210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }

        HashSet[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
//        当前结果集列表里的元素个数，正好可以作为下标
        int count = 0;

        while (!queue.isEmpty()) {
//            当前入度为0的节点
            Integer head = queue.poll();
            res[count] = head;
            count++;

            Set<Integer> successors = adj[head];
            for (Integer nextCourse :
                    successors) {
                inDegree[nextCourse]--;
//              如果入度为0，加入队列
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

//        如果结果集中的数量不等于节点的数量，就不能完成课程
        if (count == numCourses) return res;

        return new int[0];
    }

    private void dfs(List<List<Integer>> adjacency, int[] flags, LinkedList<Integer> res, int i) {
        if (res.size() == flags.length) return;
        if (flags[i] == 1) return;
        flags[i] = 1;
        res.addLast(i);
        for (Integer j: adjacency.get(i)) {
            dfs(adjacency, flags, res, j);
        }
    }
    public static void main(String[] args) {
        int[][] test = {{1,0},{2,0},{3,1},{3,2}};
//        [1,0],[2,0],[3,1],[3,2]

        System.out.println(Arrays.toString(new FindOrder210().findOrder(4, test)));
    }
}
