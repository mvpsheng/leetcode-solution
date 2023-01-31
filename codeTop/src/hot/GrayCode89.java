package hot;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: GrayCode89
 * author: gxs
 * Date: 2021/11/21  20:27
 */
public class GrayCode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
       int len = 1 << n;
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
/**
 * 二进制相差一位不同
 * */
    public boolean oneDifference(int x, int y) {
        String x1 = binaryCode(x);
        String y1 = binaryCode(y);
        int count = 0;
        int len = Math.max(x1.length(), y1.length());
        int minLen = Math.min(x1.length(), y1.length());
        StringBuilder fill = null;
        String still = "";
        if (x1.length() < y1.length()) {
            fill = new StringBuilder(x1);
            still = y1;
        } else {
            fill = new StringBuilder(y1);
            still = x1;
        }
        for (int i = minLen; i < len; i++) {
            fill.append(0);
        }
        for (int i = 0; i < len; i++) {
            if (fill.charAt(i) != still.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
/**
 * 求一个数字的二进制
 * */
private String binaryCode(int x) {
    if (x == 0) {
        return "0";
    }
    StringBuilder binaryString = new StringBuilder();
    while (x > 0) {
        int m = 1;
        m = x & m;
        x = x >> 1;
        binaryString.append(m);
    }
    return binaryString.toString();
}
    public static void main(String[] args) {
        int a = 8;
        int b = 6;
      List<Integer> res = new GrayCode89().grayCode(2);
        System.out.println(res.toString());
    }
}
