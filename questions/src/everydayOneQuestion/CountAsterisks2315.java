package everydayOneQuestion;

/**
 * FileName: CountAsterisks2315
 * author: gxs
 * Date: 2023/1/29  16:31
 */
public class CountAsterisks2315 {
    /**
     * 1. 分析约束条件,
     *      只统计不在一对'|'之间的'*',
     *      只包含偶数个'|'
     * 2. 数据结构和算法
     *      最简单的方法，只用一个变量来记录当前是否在一对'|'中，如果不在就开始统计遇到的’*‘数量
     * 3. 算法复杂度
     *      时间复杂度：字符串中每一个字符扫描一遍，所以时间复杂度为O(N);
     *      空间复杂度：只需要用到几个变量来记录当前扫描的位置特征，所以空间复杂度为O(1)。
     * 4. 核心代码
     *      int theICounter = 0;
     *      boolean outOfAPair = true;
     * 5. 测试
     *      s1 = "| *** |"
     *      s2 = "||***||"
     *      s3 = "***||"
     *      s4 = "***||***"
     * */

    public int countAsterisks(String s) {
        int theICounter = 0;
        boolean outOfAPair = true;
        int asterisks = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                theICounter++;
            }
            outOfAPair = theICounter % 2 == 0;
            if (outOfAPair && c == '*') {
                asterisks++;
            }
        }
        return asterisks;
    }

    public static void main(String[] args) {
        String[] s1 = {"| *** |", "||***||", "***||", "***||***"};
        for (String s :
                s1) {
            System.out.println(new CountAsterisks2315().countAsterisks(s));
        }
    }
}
