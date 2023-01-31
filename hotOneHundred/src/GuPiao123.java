/**
 * FileName: GuPiao123
 * author: gxs
 * Date: 2021/9/23  20:36
 */
/**
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * */
public class GuPiao123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public static void main(String[] args) {
        GuPiao123 guPiao123 = new GuPiao123();
        System.out.println(guPiao123.maxProfit(new int[]{2, 1, 4, 5, 2, 9, 7}));
    }
}
