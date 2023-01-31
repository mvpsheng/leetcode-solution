package extra;

import java.util.Scanner;

/**
 * FileName: extra.extra
 * author: gxs
 * Date: 2021/12/28  18:08
 */
public class ZeroOnePackage {
/**
 * 输入n表示有 n个物品，然后输入n组数组，分别表示价值和重量
 * 输入w表示背包能承受的最大重量，求背包能装下的最大价值
 * */
    public int getValue(int n, int[][] goods, int weight) {
        int[][] values = new int[n + 1][weight + 1];
        for (int i = 0; i < n; i++) {
            values[i][0] = 0;
        }
        for (int i = 0; i < weight; i++) {
            values[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= weight; j++) {
                //            首先考虑当前能不能装 在背包里
                if (goods[i - 1][1] <= j) {

                    values[i][j] = Math.max(values[i - 1][j],values[i - 1][j - goods[i - 1][1]] + goods[i - 1][0]);
                } else {
//                    如果装不下就等于上一件物品的价值
                    values[i][j] = values[i - 1][j];
                }
            }
        }
        return values[n][weight];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] goods = new int[n][2];
        int weight;
        Scanner sc = new Scanner(System.in);
//        前面是价值，后面是重量
        goods = new int[][]{{6, 2}, {3, 2},{5,6},{4,5}};
        weight = 10;
        System.out.println(new ZeroOnePackage().getValue(n, goods, weight));
    }
}
