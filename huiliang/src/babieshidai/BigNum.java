package babieshidai;

/**
 * FileName: BigNum
 * author: gxs
 * Date: 2021/9/10  18:24
 */
public class BigNum {
    public static int findMax(int[] A) {
        int m = A.length;
        int begin = 0;
        int end = m - 1;
        int tp = begin + (end - begin) / 2;

        while (tp > 0 && tp < m - 1) {
            if (A[tp] > A[tp + 1] && A[tp] > A[tp - 1]) {
                return A[tp];
            } else if (A[tp] < A[tp + 1]) {
                begin = tp + 1;
                tp = begin + (end - begin) / 2;
            } else {
                end = tp - 1;
                tp = begin + (end - begin) / 2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 4, 3};
        System.out.println(findMax(nums));
    }
}
