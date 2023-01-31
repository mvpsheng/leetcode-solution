package nowCoder;

/**
 * FileName: LastTwoSame
 * author: gxs
 * Date: 2021/10/13  20:23
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * 6
 * abcbcc
 *
 * 8
 * */
public class LastTwoSame {
    public int findPairs(int n,String str) {
        if (n < 3) return 0;
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        Set<Character> set = map.keySet();
        for (int i = n - 1; i >= 0; i--) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            } else {
                map.put(str.charAt(i),1);
            }
            for (char c : set) {
                if (c != str.charAt(i) && map.get(c) >= 2) {
                    count += (map.get(c) * (map.get(c) - 1)) / 2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        LastTwoSame test = new LastTwoSame();
        System.out.println(test.findPairs(n, str));
    }
}
