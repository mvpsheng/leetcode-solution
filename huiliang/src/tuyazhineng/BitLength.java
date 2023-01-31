package tuyazhineng;

import java.util.Scanner;

/**
 * FileName: tuyazhineng.BitLength
 * author: gxs
 * Date: 2021/9/2  16:16
 */

public class BitLength {
    /**
     * 输入 x行
     * n 进行 m次运算
     * */
    private static int bitLength(int n,int m){
        //对n拆解成每一位进行+m运算后求长度之和，返回长度和
        int len = String.valueOf(n).length();
        int re = 0;
        for (int i = 0; i < len; i++) {
            re += String.valueOf(String.valueOf(n).charAt(i)-'0'+m).length();
        }
        return re;
    }
    public static void start() {
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int[] n =new int[rows];
        int[] m =new int[rows];
        for (int i = 0; i < rows; i++) {
            n[i] = input.nextInt();
            m[i] = input.nextInt();
        }
        for (int i = 0; i < rows; i++) {
            System.out.println(bitLength(n[i],m[i])%(long)(10E9 + 7));
        }
    }

    public static void main(String[] args) {
        start();
    }
}
