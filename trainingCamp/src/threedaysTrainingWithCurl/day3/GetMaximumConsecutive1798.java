package threedaysTrainingWithCurl.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FileName: GetMaximumConsecutive1798
 * author: gxs
 * Date: 2023/2/4  16:59
 */
public class GetMaximumConsecutive1798 {
    /**
     *  0. 题号
     *      1798. 你能构造出连续值的最大数目
     *  1. 约束分析
     *      数组大小 >= 1
     *      数组中数据大小为[1, 4 * 10的4次方]
     *  2. 思路
     *      首先排序数组，然后用已经组成的数字，加上当前数组能不能到达想要的数字，
     *      过程中计算出来的数组用list来保存
     *  3. 数据结构与算法选择、复杂度分析
     *      时间： 需要先排序，然后遍历排序后的数组，所以是O(NLogN)
     *      空间： 需要用一个list来存储运算的结果，所以是O(N)
     *  4. 核心代码
     *
     *  5. 测试
     * */
    public int getMaximumConsecutive(int[] coins) {

        Arrays.sort(coins);
        int res = 1;
        for (int coin : coins) {
            if (coin > res) {
                break;
            }
            res += coin;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] coinss = {{1,4,10,3,1},
                {1, 1, 1, 4}};
        for (int[] coins : coinss) {
            System.out.println(new GetMaximumConsecutive1798().getMaximumConsecutive(coins));
        }
    }
}
