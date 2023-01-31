package day1;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * FileName: IsValid
 * author: gxs
 * Date: 2022/1/27  18:34
 */
public class IsValid {
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) return false;

        Map<Character, Character> pairs = new HashMap<>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>();
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
        String s = "()[]{}";
        System.out.println(new IsValid().isValid(s));
    }
}
