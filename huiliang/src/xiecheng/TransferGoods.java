package xiecheng;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * FileName: TransferGoods
 * author: gxs
 * Date: 2021/9/30  19:33
 */
public class TransferGoods {
    private int wayOfTransfer(int n,int m,int[] goods,int L,int R) {
        if (m ==0) {
            return 0;
        }
        if (n == 1 && m == 1 && goods[0] >= L && goods[0] <= R) {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextInt();
        }
        int L = sc.nextInt();
        int R = sc.nextInt();
        StringPairs wayOfTransfer = new StringPairs();
    }
}
