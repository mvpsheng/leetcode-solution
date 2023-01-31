package xiecheng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * FileName: StringPairs
 * author: gxs
 * Date: 2021/9/30  19:08
 */
/**
 * 4
 * TRIP
 * 样例输出
 * 3
 *
 * 提示
 * 样例解释
 *
 * TR和RT匹配
 *
 * IP和PI匹配
 *
 * TRIP和RTPI匹配
 * */
public class StringPairs {
    private int stringPairs(int n,String str) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        Map<String,String> map = new HashMap<>();
        map.put("TR","RT");
        map.put("RT","TR");
        map.put("IP","PI");
        map.put("PI","IP");
        map.put("TRPI","RTIP");
        map.put("RTPI","TRIP");
        map.put("TRIP","RTPI");
        map.put("RTIP","TRIP");
        map.put("IPRT","TRIP");
        map.put("IPTR","TRIP");
        map.put("PITR","TRIP");
        map.put("PIRT","TRIP");
        map.put("RTRT","TRIP");
        map.put("TRTR","TRIP");
        map.put("IPIP","TRIP");
        map.put("PIPI","TRIP");
        int left = 0,right = 1;
        int count = 0;
        while (right < str.length()) {
            String sub = str.substring(left,right + 1);
            if (map.containsKey(sub)) {
                count++;
            }
            left++;
            right++;
        }
        left = 0;
        right = 3;
        while (right < str.length()) {
            String sub1 = str.substring(left,right + 1);
            if (map.containsKey(sub1)) {
                count++;
            }
            left++;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        StringPairs stringPairs = new StringPairs();
        System.out.println(stringPairs.stringPairs(n, str));
    }
}
