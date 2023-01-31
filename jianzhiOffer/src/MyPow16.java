/**
 * FileName: MyPow16
 * author: gxs
 * Date: 2022/1/6  16:17
 */
public class MyPow16 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int x = -2;
        double y = 2.00000;
        System.out.println(new MyPow16().myPow(y, x));
    }
}
