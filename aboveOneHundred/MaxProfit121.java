package aboveOneHundred;

/**
 * FileName: MaxProfit121
 * author: gxs
 * Date: 2021/9/22  22:08
 */
public class MaxProfit121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            maxProfit = Math.max(price - min, maxProfit);
        }
        return maxProfit;
    }
}
