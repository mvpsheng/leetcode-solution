package firstTen;

import java.util.LinkedList;

/**
 * FileName: Reverse
 * author: gxs
 * Date: 2021/11/4  17:29
 */
public class Reverse {
    public int reverse(int x) {
        int res = 0;
        int last;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x % 10;
            last = res;
            res = res * 10 + tmp;
            //判断整数溢出
            if(last != res / 10) {
                return 0;
            }
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(-321));
        System.out.println(15 / 10);
    }
}
