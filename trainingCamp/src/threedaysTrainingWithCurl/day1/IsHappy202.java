package threedaysTrainingWithCurl.day1;

import java.util.HashSet;
import java.util.Set;

/**
 * FileName: IsHappy
 * author: gxs
 * Date: 2023/2/2  15:14
 */
public class IsHappy202 {
/**
 *  1. 约束分析
 *      n 属于int范围从1开始
 *
 *      结果要么算出来为1，或者算不出来1，会无限循环，说明计算的结果会重复出现
 *  2. 算法和数据结构选择
 *
 *      Set
 *  3. 复杂度
 *      时间： O(N) 不断计算，但是不能重复出现
 *      空间复杂度：O(N)
 *  4. 核心代码
 *     计算这个数的过程就是将每一位拿到之后，取平方，然后加起来。
 *     拿到每一位的方法就是 % 10，然后给n / 10；
 *
 *     如果重复在set中出现，那么就进入了无限循环，不是无限循环就看是不是1。
 *  5. 测试
 * */
    public boolean isHappy(int n) {
        Set<Integer> sum = new HashSet<>();

        while (n != 1 && !sum.contains(n)) {
            sum.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n != 0) {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }
}
