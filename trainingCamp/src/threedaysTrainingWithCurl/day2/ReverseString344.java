package threedaysTrainingWithCurl.day2;

/**
 * FileName: ReverseString344
 * author: gxs
 * Date: 2023/2/3  8:14
 */
public class ReverseString344 {
/**
 *  1. 约束分析
 *      数组长度大于等于1
 *      数组中的字符都是ascii表中可打印的字符
 *      不能额外分配空间，原地修改顺序
 *  2. 数据结构与算法选择
 *      双指针，从两头开始，交换节点的值
 *  3. 复杂度分析
 *      时间： 节点都要遍历一下，所以是O(N)
 *      空间： 常数个变量，所以是O(1)
 *  4. 核心代码
 *  5. 测试
 * */
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;

        while (i < j) {
            swap(s, i++, j--);
        }
    }
    private void swap(char[] s, int i, int j) {
//        char temp = s[i];
//        s[i] = s[j];
//        s[j] = temp;
//        交换值的第二种写法
        s[i] ^= s[j];
        s[j] ^= s[i];
        s[i] ^= s[j];
    }
}
