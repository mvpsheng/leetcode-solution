package day1;

/**
 * FileName: MaxProfit
 * author: gxs
 * Date: 2022/1/27  13:06
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }
}
