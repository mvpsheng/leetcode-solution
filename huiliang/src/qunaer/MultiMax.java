package qunaer;

import java.util.Arrays;

/**
 * FileName: MultiMax
 * author: gxs
 * Date: 2021/9/14  18:50
 */
public class MultiMax {
    public int solution(int[] arr) {
        int max = 0;
        Arrays.sort(arr);
        int start = 0;
        while (start < arr.length) {
            int temp = 0;
            int count = 1;
            for (int i = start; i < arr.length; i++) {
                temp += arr[i] * count++;
            }
            max = Math.max(max,temp);
            start++;
        }
        return  max;
    }

    public static void main(String[] args) {
        MultiMax multiMax = new MultiMax();
        int[] arr = {-1,1,4,-9,-8};
        System.out.println(multiMax.solution(arr));
    }
}
