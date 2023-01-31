/**
 * FileName: GuPiao63
 * author: gxs
 * Date: 2021/9/23  20:16
 */
/**
 * 之前版本，在for循环中，每次进行两个对比，
 * 之后换成if语句的判断，每次只执行一次比较，性能提高一倍
 * min = Math.min(num,min);
 * maxProfit = Math.max(maxProfit,num - min);
 * */
public class GuPiao63 {
    public int maxProfit(int[] prices) {
//        代码优化后的结果，性能提高一倍
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int num : prices) {
            if (num < min) {
                min = num;
            } else if (num - min > maxProfit) {
                maxProfit = num - min;
            }
        }
        return maxProfit;
    }
}
