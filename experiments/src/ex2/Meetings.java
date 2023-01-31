package ex2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName: Meetings
 * author: gxs
 * Date: 2021/12/13  9:46
 */
public class Meetings {
    public int solution1(int[] s, int[] e) {
        int m = s.length;
        int n = e.length;
        int num = 1;
        int i = 1;
        int j = 0;
        while (i < m - 1 && j < n - 1) {
            if (s[i] < e[j]) {
                num++;
            }
            if (s[i] > e[j]) {
                j = i;
            }
            i++;
        }
        return num;
    }
    public int solution2(int[] s, int[] e) {
        int m = s.length;
        int n = e.length;
        int num = 1;
        Map<Integer,Character> record = new HashMap<>();
        int[] c = new int[m + n];
        for (int i = 0; i < m; i++) {
            c[i] = s[i];
            record.put(s[i],'s');
        }
        for (int i = m; i < m + n; i++) {
            c[i] = e[i - m];
            record.put(e[i - m],'e');
        }
        Arrays.sort(c);
        for (int i = 0; i < m + n - 1; i++) {
            if (record.get(c[i]) == record.get(c[i + 1]) && record.get(c[i]) == 's') {
               num++;
            }
        }
       return num;
    }
    public static void main(String[] args) {
        int[] s = {1,12,25,27,36};
        int[] e = {23,28,35,80,50};
        System.out.println(new Meetings().solution1(s, e));
        System.out.println(new Meetings().solution2(s, e));
    }
}
