import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * FileName: GetLeastNumbers40
 * author: gxs
 * Date: 2022/1/16  18:58
 */
public class GetLeastNumbers40 {
    public int[] getLeastNumbers(int[] arr, int k) {
//        int[] vec = new int[k];
//        if (k == 0) {
//            return vec;
//        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        for (int i = 0; i < k; i++) {
//            queue.offer(arr[i]);
//        }
//        for (int i = k; i < arr.length; i++) {
//            if (queue.peek() > arr[i]) {
//                queue.poll();
//                queue.offer(arr[i]);
//            }
//        }
//        for (int i = 0; i < k; i++) {
//            vec[i] = queue.poll();
//        }
//        return vec;

//        解法二：
        if (k == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> bigRoot = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int e : arr) {
            if (bigRoot.size() < k) {
                bigRoot.offer(e);
            } else if (e < bigRoot.peek()) {
                bigRoot.poll();
                bigRoot.offer(e);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = bigRoot.poll();
        }
        return res;
    }
}
