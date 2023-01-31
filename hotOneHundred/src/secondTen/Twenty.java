package secondTen;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * FileName: Twenty
 * author: gxs
 * Date: 2021/9/16  11:07
 */
public class Twenty {
    public boolean isValid(String s) {
       int len = s.length();
       if (len % 2 == 1) {
           return false;
       }

        Map<Character,Character> pairs = new HashMap<Character,Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
       }};
       Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Twenty test = new Twenty();
        System.out.println(test.isValid("{[()]}"));
    }
}