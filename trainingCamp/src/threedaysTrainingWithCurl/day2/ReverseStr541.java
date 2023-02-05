package threedaysTrainingWithCurl.day2;

/**
 * FileName: ReverseStr541
 * author: gxs
 * Date: 2023/2/3  8:35
 */
public class ReverseStr541 {
    /**
     *  1. 约束分析
     *      数组长度大于等于1
     *      数组中的字符是小写字母
     *      k>=1
     *      计数每2k反转前K
     *      剩余的小于k，全部反转
     *      如果大于等于k，但小于2k，反转前k
     *  2. 数据结构与算法选择
     *      采用344的双指针，从两头开始，交换节点的值
     *  3. 复杂度分析
     *      时间： 节点都要遍历一下，所以是O(N)
     *      空间： 常数个变量，所以是O(1)
     *  4. 核心代码
     *  5. 测试
     * */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, chars.length - 1);

            while (start < end) {
                chars[start] ^= chars[end];
                chars[end] ^= chars[start];
                chars[start] ^= chars[end];
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s = "ab";
        int k = 2;
        System.out.println(new ReverseStr541().reverseStr(s, k));
    }
}
