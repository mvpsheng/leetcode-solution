package recursionanddynamicprogramming;

/**
 * FileName: RepresentingNCents
 * author: gxs
 * Date: 2022/1/22  18:03
 */
/* given an infinite number of quars (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent),
 * write code to calculate the number of ways of representing n cents */
public class RepresentingNCents {
    int makeChange(int n) {
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[n + 1][denoms.length];
        return makeChange(n, denoms, 0, map);
    }

    int makeChange(int amount, int[] denoms, int index, int[][] map) {
        if (map[amount][index] > 0) {
            return map[amount][index];
        }
        if (index >= denoms.length - 1) return 1;
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount < amount; i++) {
            //go to next denom, assuming i coints of denomAmount
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1, map);
        }
        map[amount][index] = ways;
        return ways;
    }

    public static void main(String[] args) {
        int n = 80;
        System.out.println(new RepresentingNCents().makeChange(n));
    }
}
