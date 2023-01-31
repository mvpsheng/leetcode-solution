import java.util.HashMap;
import java.util.Map;

/**
 * FileName: LengthOfLongestSubstring48
 * author: gxs
 * Date: 2022/1/16  11:20
 */
public class LengthOfLongestSubstring48 {
    public int lengthOfLongestSubstring(String s) {
//        解法一：动态规划
//        int curLength = 0;
//        int maxLength = 0;
//
//        int[] position = new int[26];
//        for (int i = 0; i < 26; i++) {
//            position[i] = -1;
////            存储-1表示该字符没有出现过
//        }
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < s.length(); i++) {
////            preindex 存储该字母上一次出现的位置
//            int preIndex = position[chars[i] - 'a'];
//            if (preIndex < 0 || i - preIndex > curLength) {
////                如果该字符之前没有出现过，或者当前距离更大
//                ++curLength;
//            } else {
//                if (curLength > maxLength)
//                    maxLength = curLength;
//                curLength = i - preIndex;
//            }
////            更新该字母出现的位置为下标i
//            position[chars[i] - 'a'] = i;
//        }
//        if (curLength > maxLength)
//            maxLength = curLength;
//        return maxLength;
//        解法二：双指针
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j)));
            }
            dic.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new LengthOfLongestSubstring48().lengthOfLongestSubstring(s));
    }
}
