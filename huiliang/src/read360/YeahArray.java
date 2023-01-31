package read360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * FileName: YeahArray
 * author: gxs
 * Date: 2021/9/25  15:51
 */
/**
 * 若数列a1…an，对于任意1<i<n的位置满足：a[i+1]>a[i]或a[i-1]>a[i] ，那么称这个数列为yeah数列。（通俗的理解，yeah数列除两端外，对于任意一个位置，左右两边至少有一个比他大）。
 *
 * 比如4 1 8 或 1 2 3或 8 6 4 2就是yeah数列，而1 1 1和0 1 0就不是yeah数列
 *
 * 现在有一个数列b1…bn，每次操作你可以选择一个i，使得bi减1(操作过程中允许bi减为负数)，问最少经过多少次操作，可以使得bi变为一个yeah数列
 * */
public class YeahArray {
    public void makeYeahArray(int length,int[] nums) {
        if (length < 2) {
            System.out.println(0);
        }
        int counts = 0;
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 1; i < length - 1; i++) {
                if (nums[i] >= nums[i - 1] && nums[i] >= nums[i + 1]) {
                    int tmp = nums[i];
                    nums[i] = Math.max(nums[i - 1],nums[i + 1]) - 1;
                    counts += tmp - nums[i];
                    changed = true;
                }
            }
        }
        System.out.println(counts);
        for (int num :
                nums) {
            System.out.print(" "+ num);
        }
    }

    public static void main(String[] args) {
        YeahArray yeahArray = new YeahArray();
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        yeahArray.makeYeahArray(len, nums);
    }
}
