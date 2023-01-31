package day1;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: IsAnagram
 * author: gxs
 * Date: 2022/1/27  17:44
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
//        判断两个字符串的长度相等
//        if (s.length() != t.length()) {
//            return false;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//                map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            char ch = t.charAt(i);
//            map.put(ch, map.getOrDefault(ch, 0) - 1);
//            if (map.get(ch) < 0) {
//                return false;
//            }
//        }
//        return true;
//        方法二：存储在数组中
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a']--;
        }
        for (int i : record) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "dgqztusjuu";
        String t = "dqugjzutsu";
        System.out.println(new IsAnagram().isAnagram(s, t));
    }
}
