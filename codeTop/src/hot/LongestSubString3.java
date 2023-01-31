package hot;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: LongestSubString3
 * author: gxs
 * Date: 2021/9/30  9:46
 */
public class LongestSubString3 {
    static int lengthOfLongestSubString (String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0,j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i,map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j),j);
            max = Math.max(max,j - i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubString("abcabcbb"));
    }
}
