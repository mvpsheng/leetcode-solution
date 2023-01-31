package qunaer;

import java.util.Arrays;

/**
 * FileName: BigNums
 * author: gxs
 * Date: 2021/9/14  17:35
 */
public class BigNums {
/**
 *
 *
 * 可以整除3的最大数字之和
 * */
    public String find(int[] nums) {
        int len = nums.length - 1;
        int[] res = new int[len + 1];
        int count = 0; //统计0出现的次数
        int countNums = 0;
        Arrays.sort(nums);
        for (int i = len; i >= 0; i--) {
            if (nums[i] == -1) {
                continue;
            }
            if (nums[i] == 0) {
                count++;
                continue;
            }
            if (nums[i] % 3 == 0) {
                    res[len - i] = nums[i];
                    countNums++;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if ((nums[i] + nums[j]) % 3 == 0) {
                        res[len - i] = nums[i];
                        res[len - j] = nums[j];
                        nums[j] = -1;
                        countNums += 2;
                        break;
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= len; i++) {
            if (i <= countNums && res[i] != 0)
                result.append(res[i]);
        }
        while (count > 0) {
            result.append(0);
            count--;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        BigNums bigNums = new BigNums();
        int[] nums = {3,6,1,2,9,8,0};
        System.out.println(bigNums.find(nums));
    }
}
