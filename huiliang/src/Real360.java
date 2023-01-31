import java.util.Random;
import java.util.Scanner;

/**
 * FileName: Real360
 * author: gxs
 * Date: 2021/9/25  15:41
 */
/**
 * 最近，小七发现了一处干涸的河道。
 *
 * 河道不同的位置高度也不相同，从河道起点到终点有n个位置，这些位置编号为1~n。每一个位置i的高度可以表示为hi(1、n是河道的两端，因此1左边、n右边的高度可以视为无穷大)。
 *
 * 本着环保的精神，小七希望在恰好一个位置注入水源，使得这个位置是有水的。自然地，水会从高处向低处流动，但原来的位置仍然有水。具体地来说，如果当前一个位置i是有水的，并且有某一个相邻的格子j高度严格小于i(hj < hi)，那么j也会成为有水的，并且i仍然是有水的。对于j相邻的格子也是如此。
 *
 * 现在小七想知道，通过一次注入水源最多可以使得多少个位置变成有水的
 *
 *
 *
 * 输入描述
 * 第一行一个正整数n(1<=n<=5000)，表示河道有n个位置
 *
 * 第二行n个正整数，第i个表示位置i的高度hi(0<=hi<=1000000000)
 * */
public class Real360 {
    public int maxNum(int length,int[] nums) {
        if (length == 1) {
            return 1;
        }
        if (length == 2) {
            if (nums[0] == nums[1]) {
                return 1;
            } else {
                return 2;
            }
        }
        int max = 0;
        int left ,right;
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                left = i - 1;right = i + 1;
                while (nums[left] > nums[left - 1] && left - 1 > 0) {
                    left--;
                }
                if (nums[left] > nums[left - 1]) {
                    left--;
                }
                while (nums[right] > nums[right + 1] && right + 1 < length - 1) {
                    right++;
                }
                if (nums[right] > nums[right + 1]) {
                    right++;
                }
                max = Math.max(max,right - left + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Real360 real360 = new Real360();
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(real360.maxNum(len, nums));
    }
}
