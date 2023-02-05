package threedaysTrainingWithCurl.day2;

/**
 * FileName: ReverseLeftWords58
 * author: gxs
 * Date: 2023/2/3  13:37
 */
public class ReverseLeftWords58 {
    /**
     *  剑指 Offer 58 - II. 左旋转字符串 LCOF
     *  1. 约束分析
     *     s.length > n >= 1
     *  2. 思路
     *        反转前n个字符
     *        反转n到末尾的字符
     *        反转整个字符
     *  3. 数据结构与算法选择、复杂度分析
     *      时间： 反转一次时间复杂度为O(N)，所以还是O(N)
     *      空间： 不利用其他空间，所以是O(1)
     *  4. 核心代码
     *  5. 测试
     * */
    public String reverseLeftWords(String s, int n) {
        char[] str = s.toCharArray();

        reverseStr(str, 0, n - 1);
        reverseStr(str, n, s.length() - 1);
        reverseStr(str, 0, s.length() - 1);
        return new String(str);
    }

    private void reverseStr(char[] str, int i, int n) {
        int start = i;
        int end = n;
        while (start < end) {
            str[start] ^= str[end];
            str[end] ^= str[start];
            str[start] ^= str[end];
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String test = "abcdefg";
        int n = 2;
        System.out.println(new ReverseLeftWords58().reverseLeftWords(test, n));
    }

}
