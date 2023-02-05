package threedaysTrainingWithCurl.day2;

/**
 * FileName: ReverseWords151
 * author: gxs
 * Date: 2023/2/3  9:12
 * 151. 反转字符串中的单词
 */
public class ReverseWords151 {
    /**
     *  1. 约束分析
     *      字符串长度大于等于1
     *      包含大小写字母，数字和空格
     *      至少有一个单词
     *      可能有前后的空格，单词之间有多余的控制，最后只要单词之间存在一个空格
     *  2. 思路
     *      首先处理多余空格
     *      反转整个字符串
     *      反转每个单词
     *  3. 数据结构与算法选择，复杂度分析
     *      时间： ，所以是O(N)
     *      空间： ，所以是O(1)
     *  4. 核心代码
     *  5. 测试
     * */
    public String reverseWords(String s) {
        StringBuilder sb =  remoteBlanks(s);
        reverseStr(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseStr(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    private void reverseStr(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    private StringBuilder remoteBlanks(String s) {
//        去除多余的空格
//        利用快慢指针来做
//        去除前面的空格
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
}
