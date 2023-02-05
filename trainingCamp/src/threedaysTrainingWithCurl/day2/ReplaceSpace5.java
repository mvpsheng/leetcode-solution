package threedaysTrainingWithCurl.day2;

/**
 * FileName: ReplaceSpace5
 * author: gxs
 * Date: 2023/2/3  8:52
 * 剑指Offer 05.替换空格
 */
public class ReplaceSpace5 {
    /**
     *  1. 约束分析
     *      将字符串转化为数组来做
     *      数组长度可能为0
     *  2. 数据结构与算法选择
     *      双指针，
     *      扩展数组之后，一个指针指向扩展后的最有一个节点，一个指针指向扩展前的最后一个节点
     *  3. 复杂度分析
     *      时间： 节点都要遍历一下，所以是O(N)
     *      空间： 常数个变量，所以是O(1)
     *  4. 核心代码
     *  5. 测试
     * */
    public String replaceSpace(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                str.append("  ");
            }
        }
        if (str.length() == 0) {
            return s;
        }

        int left = s.length() - 1;
        s += str.toString();
        int right = s.length() - 1;
        char[] res = s.toCharArray();
        while (left >= 0) {
            if (res[left] == ' ') {
                res[right--] = '0';
                res[right--] = '2';
                res[right] = '%';
            } else {
                res[right] = res[left];
            }
            left--;
            right--;
        }
        return new String(res);
    }
}
