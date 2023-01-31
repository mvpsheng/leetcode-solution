package microsoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * FileName: MergeList
 * author: gxs
 * Date: 2021/10/16  16:07
 */
public class MergeList {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 2) {
            return 0;
        }
        if (A.length == 2) {
            return A[0] + A[1];
        }
        Arrays.sort(A);
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= A.length / 2; i += 2) {
            queue.add(A[i] + A[i + 1]);
        }
        if (A.length % 2 != 0) {
            queue.add(A[A.length - 1]);
        }
        while (queue.size() > 1) {
                Integer a = queue.poll();
                Integer b = queue.poll();
                queue.add(a + b + a);
        }
        int time = queue.get(0);
        return time;
    }

    public static void main(String[] args) {
        int[] a = {50,2,3,78};
        MergeList mergeList = new MergeList();
        System.out.println(mergeList.solution(a));
    }
}
