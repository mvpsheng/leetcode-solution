package aboveOneHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: IsAnagram
 * author: gxs
 * Date: 2021/9/26  18:41
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
//        解法一：时间复杂度O(n),空间复杂度O(s)  s表示新建数组的长度
//        if (s.length() != t.length()) {
//            return false;
//        }
//        int[] nums = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            nums[s.charAt(i) - 'a']++;
//            nums[t.charAt(i) - 'a']--;
//        }
//        for (int num :
//                nums) {
//            if (num != 0) {
//                return false;
//            }
//        }
//        return true;

//        解法二：
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer> table = new HashMap<Character,Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch,table.getOrDefault(ch,0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch,table.getOrDefault(ch,0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
