package jianzhioffer;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * FileName: GetLeastNumbers40
 * author: gxs
 * Date: 2022/3/16  10:40
 */
public class GetLeastNumbers40 {
    public int[] getLeastNumber(int[] arr, int k) {
        int[] res = new int[k];
        if (arr.length == 0 || k == 0) return new int[]{};
        PriorityQueue<Integer> q = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int e : arr) {
            if (k > q.size()) {
                q.offer(e);
            } else if (e < q.peek()) {
                    q.poll();
                    q.offer(e);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(new GetLeastNumbers40().getLeastNumber(arr, k)));
    }
}
