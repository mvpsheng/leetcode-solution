package jianzhioffer;

import java.util.HashMap;

/**
 * FileName: LengthOfLongestSubstring48
 * author: gxs
 * Date: 2022/3/16  10:21
 */
public class LengthOfLongestSubstring48 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0, max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
