package aboveOneHundred;

/**
 * FileName: MaxProfit122
 * author: gxs
 * Date: 2021/9/22  22:15
 */
/**
 * [7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * */
public class MaxProfit122 {
    public int maxProfit(int[] prices) {
//        解法三：将动态规划中的二位数组用两个变量来替换，俗称滚动变量
//        int cash = 0;
//        int hold = -prices[0];
//
//        int preCash = cash;
//        int preHold = hold;
//        for (int i = 1; i < len; i++) {
//            cash = Math.max(preCash, preHold + prices[i]);
//            hold = Math.max(preHold, preCash - prices[i]);
//
//            preCash = cash;
//            preHold = hold;
//        }
//        return cash;

//        解法一：贪心算法
//        int maxProfit = 0;
//        for (int i = 1; i < prices.length; i++) {
//            maxProfit += Math.max(0,prices[i] - prices[i - 1]);
//        }
//        return maxProfit;

//        解法二：动态规划
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        MaxProfit122 maxProfit122 = new MaxProfit122();
        System.out.println(maxProfit122.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
