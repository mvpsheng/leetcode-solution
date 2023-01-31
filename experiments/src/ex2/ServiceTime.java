package ex2;

import java.util.Arrays;

/**
 * FileName: ServiceTime
 * author: gxs
 * Date: 2021/12/13  10:20
 */
public class ServiceTime {
    public int shortestService(int n, int site, int[] time) {
//        排序客户服务时间
        Arrays.sort(time);
        int ans = 0;
        int[] column = new int[site];
//        将客户服务时间按服务点分组
        int[][] times = new int[site][n / site];
        for (int j = 0; j < n; j++) {
            times[j % site][column[j % site]++] = time[j];
        }
        for (int j = 0; j < site; j++) {
            for (int i = 0; i < n / site; i++) {
//               统计用户总等待时间
                ans += times[j][i] * column[j]--;
            }
        }
        return  ans / n;
    }
    public static void main(String[] args) {
        int n = 10;
        int site = 2;
        int[] time = {56,12,1,99,1000,234,33,55,99,812};
       System.out.println(new ServiceTime().shortestService(n, site, time));
    }
}
