package ex2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * FileName: MinimumWrightMachine
 * author: gxs
 * Date: 2021/12/17  10:11
 */
public class MinimumWrightMachine {
    static int bestWeight = Integer.MAX_VALUE;
    static int count = 1;
    static int[] bestIndex;
    public void backtrack(int t, int n, int m, int d, int curWeight, int curPrice, Deque<Integer> index, Deque<Integer> ans, int[][] c, int[][] w) {
        if (t == n) {
            count--;
            if (curWeight < bestWeight && curPrice <= d) {
                bestWeight = curWeight;
                int i = 0;
                for (int num : index) {
                    bestIndex[i++] = num;
                }
            }
            if (count == 0) {
                System.out.println(bestWeight);
                for (int i = 0; i < bestIndex.length; i++) {
                    System.out.print(bestIndex[i] + " ");
                }
            }
        } else {
                for (int j = 0; j < m; j++) {
                    curPrice += c[t][j];
                    curWeight += w[t][j];
                    index.addLast((j + 1));
                    backtrack(t + 1, n, m, d, curWeight, curPrice, index, ans, c, w);
                    curPrice -= c[t][j];
                    curWeight -= w[t][j];
                    index.removeLast();
                }
        }
    }
    public static void main(String[] args) {
        int n = 3; //n个机器部件
        int m = 3;  //m个厂商
        int d = 4; //机器最大重量
        int[][] c = {{1, 2, 3}, {3, 2, 1},{2,2,2}}; //价格
        int[][] w = {{1, 2, 3}, {3, 2, 1},{2,2,2}}; //重量
        int curPrice = 0;int curWeight = 0;
        Deque<Integer> ans = new LinkedList<>();
        Deque<Integer> index = new LinkedList<>();
        count = (int) Math.pow(n,m);
        bestIndex = new int[n];
        new MinimumWrightMachine().backtrack(0, n, m, d, curWeight, curPrice, index, ans, c, w);
    }
}
