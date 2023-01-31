import java.util.HashMap;
import java.util.Map;

/**
 * FileName: FirstUniqChar50
 * author: gxs
 * Date: 2022/1/10  9:10
 */
public class FirstUniqChar50 {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(new FirstUniqChar50().firstUniqChar(s));
    }
}
