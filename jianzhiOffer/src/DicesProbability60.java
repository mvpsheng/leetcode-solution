import java.util.Arrays;

/**
 * FileName: DicesProbability60
 * author: gxs
 * Date: 2021/12/21  15:48
 */
public class DicesProbability60 {
    public double[] dicesProbability(int n) {
// 一个骰子时,一共有6种可能
        double[] dp = new double[6];
        Arrays.fill(dp,1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
//            每次添加一个骰子时,可能的结果之和有n-6n之间,一共5 * n + 1种
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
// j + k 保存的是前i - 1个骰子的运算中第j个运算结果 + 当前骰子的6个概率中的一个
                    tmp[j + k] += dp[j] * (1.0 / 6.0);
                }
            }
// 将i个骰子的点数概率计算结果从tmp转移到dp中，用于计算i + 1个骰子的结果
            dp = tmp;
        }
        return dp;
    }
}
