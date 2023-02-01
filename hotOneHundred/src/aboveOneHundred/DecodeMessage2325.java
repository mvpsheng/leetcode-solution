package aboveOneHundred;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName: DecodeMessage2325
 * author: gxs
 * Date: 2023/2/1  8:03
 */
public class DecodeMessage2325 {
/**
 *  1. 分析约束
 *     key是密钥 大于等于26的长度，key包含小写字母及空格，其中‘a' 到 ’z‘至少出现一次；
 *     message 加密信息 -- 长度大于等于1，包含小写字母及空格
 *  2. 数据结构与算法选择
 *      选择用哈希表的键值对来保存 这个密钥信息对
 *      或者用二维数组
 *  3. 复杂度分析
 *      因为加密信息的每个字符都要遍历一遍，所以时间复杂度为O(N)
 *      空间复杂度：需要一个二维数组或者哈希表来存储辅助信息，所以空间复杂度为O(N)
 *  4. 核心代码
 *      首先遍历key，获取密钥的兑换码
 *      然后遍历加密信息，直接对每个字符进行解密
 *  5. 测试
 *
 * */
    public String decodeMessage(String key, String message) {
        //        方法1： 用map来存储key，value 解密方法
//        Map<Character, Character> values = new HashMap<>();
////分析解密值的过程
//        int i = 0;
//        for (char c : key.toCharArray()) {
//            if (c != ' ' && ! values.containsKey(c)) {
//                    values.put(c, (char)(i + 'a'));
//                    i++;
//            }
//            if (values.size() == 26) {
//                break;
//            }
//        }
////        解密过程
//        StringBuilder sb = new StringBuilder();
//        for (char c : message.toCharArray()) {
//            if (c == ' ') {
//                sb.append(' ');
//            } else {
//                sb.append(values.get(c));
//            }
//        }
//        return sb.toString();
//        方法2： 用数组来存储解密方法， 通过记录该字符出现的次序来得到解密值
//        数组长度为123，因为a的asciima为97，26个字母，所以索引下标需要123个
        int[] decode = new int[123];
        Arrays.fill(decode, -1);
        int id = 0;
        for (char c : key.toCharArray()) {
            if (c == ' ') continue;
            if (decode[c] == -1) {
                decode[c] = id++;
            }
        }

        char[] decodeRes = message.toCharArray();
        for (int i = 0; i < decodeRes.length; i++) {
            if (decodeRes[i] == ' ') continue;
            decodeRes[i] = (char)(decode[decodeRes[i]] + 'a');
        }
        return new String(decodeRes);
    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println(new DecodeMessage2325().decodeMessage(key, message));
    }
}
