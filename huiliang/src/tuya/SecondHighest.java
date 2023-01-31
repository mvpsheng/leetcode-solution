package tuya;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * FileName: SecondHighest
 * author: gxs
 * Date: 2021/9/26  20:12
 */
public class SecondHighest {
    public int secondHighest (String s) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - 'a' < 0) {
                res.add(s.charAt(i) - '0');
            }
        }
        System.out.println(res.size());
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        Arrays.sort(ans);
        return ans[ans.length - 2];
    }

    public static void main(String[] args) {
        SecondHighest secondHighest = new SecondHighest();
        System.out.println(secondHighest.secondHighest("dfaasdxcvaedsfa1234685732921afd"));
    }
}
